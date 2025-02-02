package com.example.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javaUtils.JwtUtil;

import java.io.IOException;
import java.security.Key;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
    private static final Key SECRET_KEY = JwtUtil.SECRET_KEY;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            return;
        }
        
        String token = authHeader.substring("Bearer".length()).trim();
        try {
            Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
            
            requestContext.setProperty("username", claims.getSubject());
            requestContext.setProperty("role", claims.get("role", String.class)); // Nuevo: guardar rol
        } catch (Exception e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}
