package com.eiv.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockserver.mock.OpenAPIExpectation.openAPIExpectation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eiv.dto.Usuario;

@SpringBootTest
public class UsuarioServiceTest {
    
    @Autowired private UsuarioService usuarioService;
    
    private static ClientAndServer mockServer;

    @BeforeAll
    public static void startMockServer() {
        mockServer = ClientAndServer.startClientAndServer(8080);
    }

    @AfterAll
    public static void stopMockServer() {
        mockServer.stop();
    }
    
    @Test
    public void whenConsultaUsuarios_thenReturnOk() {
        
        MockServerClient client = new MockServerClient("localhost", mockServer.getPort());
        client.upsert(
                    openAPIExpectation("openapi.yaml")
                );
        
        Usuario usuario = usuarioService.buscarUsuarios();
        
        assertThat(usuario).isNotNull();
        assertThat(usuario.getId()).isEqualTo(10);
        assertThat(usuario.getNombre()).isEqualTo("Ismael");
        
        client.close();
    }

}
