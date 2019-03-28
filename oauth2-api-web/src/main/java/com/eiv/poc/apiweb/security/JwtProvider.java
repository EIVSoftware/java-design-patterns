package com.eiv.poc.apiweb.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Service;

import com.eiv.poc.apiweb.oauth2.OAuth2UserInfo;
import com.eiv.poc.apiweb.oauth2.OAuth2UserInfoFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class JwtProvider {

    private static final Logger LOG = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${app.auth.tokenSecret}")
    private String tokenSecret;
    
    @Value("${app.auth.tokenExpirationMsec}")
    private Long tokenExpiration;
    
    public String createToken(Authentication authentication) {

        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(
                oAuth2User.getAttributes());
        
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + tokenExpiration);
        
        return Jwts.builder()
            .setSubject(userInfo.getId().toString())
            .setIssuedAt(new Date())
            .setExpiration(expiryDate)
            .claim("nombreCompleto", userInfo.getNombreCompleto())
            .signWith(SignatureAlgorithm.HS512, tokenSecret)
            .compact();
    }
    
    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(tokenSecret)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }
    
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            LOG.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            LOG.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            LOG.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            LOG.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            LOG.error("JWT claims string is empty.");
        }
        return false;
    }
}
