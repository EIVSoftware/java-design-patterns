package com.eiv.poc.apiweb.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.eiv.poc.apiweb.entities.UsuarioEntity;
import com.eiv.poc.apiweb.services.UsuarioService;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger LOG = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    
    @Autowired JwtProvider jwtProvider;
    @Autowired UsuarioService usuarioService;
    
    @Autowired private PlatformTransactionManager transactionManager = null;
    
    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        try {
            String jwt = getJwtFromRequest(request);
            
            if (jwt != null && jwtProvider.validateToken(jwt)) {
                
                LOG.debug("JWT recibido del cliente: {}", jwt);
                
                Long userId = jwtProvider.getUserIdFromToken(jwt);
                
                TransactionTemplate template = new TransactionTemplate(transactionManager);
                template.execute(new TransactionCallbackWithoutResult() {
                    @Override
                    protected void doInTransactionWithoutResult(TransactionStatus status) {
                        
                        Optional<UsuarioEntity> usuarioOptional = usuarioService
                                .findyById(userId);

                        usuarioOptional.ifPresent(usuarioEntity -> {
                            
                            UserPrincipal userPrincipal = UserPrincipal.create(usuarioEntity);
                            
                            UsernamePasswordAuthenticationToken authentication = 
                                    new UsernamePasswordAuthenticationToken(
                                            userPrincipal, 
                                            null, 
                                            userPrincipal.getAuthorities());
                            
                            authentication.setDetails(
                                new WebAuthenticationDetailsSource().buildDetails(request));

                            SecurityContextHolder.getContext().setAuthentication(authentication);
                        });
                    }
                });
            }
            
        } catch (Exception ex) {
            LOG.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(request, response);
    }
    
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
