#!/bin/bash
mvn spring-boot:run -Dspring-boot.run.arguments=--logging.level.com.eiv.poc.apiweb=DEBUG,--spring.security.oauth2.client.registration.eivas.clientId=2de13e3bbee54efe583b33f42165ddc0.PAWC.eiv.com.ar,--spring.security.oauth2.client.registration.eivas.clientSecret=63c9c1744e3d5c7d75efe160befbec89,--spring.security.oauth2.client.provider.eivas.authorization-uri=http://localhost:8081/oauth/authorize,--spring.security.oauth2.client.provider.eivas.token-uri=http://localhost:8081/oauth/token,--spring.security.oauth2.client.provider.eivas.user-info-uri=http://localhost:8081/me

