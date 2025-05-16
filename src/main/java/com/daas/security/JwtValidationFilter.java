package com.daas.security;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.time.Instant;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JwtValidationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("[JWT Filter] Triggered at: " + Instant.now());
        System.out.println("Request URI: " + requestContext.getUriInfo().getRequestUri());
        System.out.println("HTTP Method: " + requestContext.getMethod());
        System.out.println("Headers:");

        for (var entry : requestContext.getHeaders().entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue());
        }

        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("No or invalid Authorization header");
            return;
        }

        String token = authHeader.substring("Bearer".length()).trim();
        System.out.println("JWT Received: " + token);
    }
}
