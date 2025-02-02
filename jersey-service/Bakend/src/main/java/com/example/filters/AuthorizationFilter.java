package com.example.filters;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.model.ResourceMethod;
import com.example.annotations.JWTTokenNeeded;
import java.lang.reflect.Method;

@Provider
@JWTTokenNeeded
public class AuthorizationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        try {
            String requiredRole = getRequiredRole(requestContext);
            String userRole = (String) requestContext.getProperty("role");
            
            if (userRole == null || !requiredRole.equalsIgnoreCase(userRole)) {
                abortWithForbidden(requestContext);
            }
        } catch (Exception e) {
            abortWithForbidden(requestContext);
        }
    }

    private String getRequiredRole(ContainerRequestContext context) {
        ResourceMethod resourceMethod = (ResourceMethod) context.getProperty(
            "javax.ws.rs.container.ResourceMethod"
        );
        
        if (resourceMethod == null) {
            throw new WebApplicationException("Recurso no encontrado", Response.Status.INTERNAL_SERVER_ERROR);
        }
        
        // Obtener el método Java reflejado correctamente
        Method javaMethod = resourceMethod.getInvocable().getHandlingMethod();
        
        // Buscar anotación en el método primero
        JWTTokenNeeded methodAnnotation = javaMethod.getAnnotation(JWTTokenNeeded.class);
        
        // Si no está en el método, buscar en la clase
        if (methodAnnotation == null) {
            methodAnnotation = javaMethod.getDeclaringClass().getAnnotation(JWTTokenNeeded.class);
        }
        
        if (methodAnnotation == null || methodAnnotation.value().length == 0) {
            throw new WebApplicationException("Rol no configurado", Response.Status.INTERNAL_SERVER_ERROR);
        }
        
        return methodAnnotation.value()[0];
    }

    private void abortWithForbidden(ContainerRequestContext ctx) {
        ctx.abortWith(Response.status(Response.Status.FORBIDDEN)
            .entity("Acceso denegado: Rol no autorizado").build());
    }
}