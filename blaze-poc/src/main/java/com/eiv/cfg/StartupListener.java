package com.eiv.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class StartupListener {

    @Value("${server.port}")
    private String serverPort;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Swagger: http://localhost:{}/swagger-ui.html", serverPort);
    }
}
