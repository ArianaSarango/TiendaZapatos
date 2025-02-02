package com.example.rest;

import controller.Dao.servicies.UsuarioServices;
import controller.tda.list.LinkedList;
import models.Usuario;
import javaUtils.JwtUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("auth")
public class AuthApi {
    private static final Logger LOGGER = Logger.getLogger(AuthApi.class.getName());

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(HashMap<String, Object> credentials) {
        try {
            String usuario = credentials.get("usuario").toString();
            String password = credentials.get("password").toString();
            
            LOGGER.info("Intento de login para: " + usuario);
            
            UsuarioServices usuarioService = new UsuarioServices();
            LinkedList<Usuario> usuarios = usuarioService.ListAll();
            
            // Depuración crítica
            LOGGER.info("Total de usuarios cargados: " + usuarios.getSize());
            if (usuarios.getSize() == 0) {
                LOGGER.severe("¡No se cargaron usuarios desde el JSON!");
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                             .entity(errorResponse("Error en configuración del servidor")).build();
            }
            
            Usuario user = null;
            for (int i = 0; i < usuarios.getSize(); i++) {
                Usuario u = usuarios.get(i);
                LOGGER.info("Comparando con: " + u.getUsuario());
                if (u.getUsuario().equals(usuario) && u.getPassword().equals(password)) {
                    user = u;
                    break;
                }
            }
            
            if (user == null) {
                LOGGER.warning("Credenciales inválidas para: " + usuario);
                return Response.status(Response.Status.UNAUTHORIZED)
                             .entity(errorResponse("Credenciales inválidas")).build();
            }
            
            String token = JwtUtil.generateToken(user.getUsuario(), user.getRol());
            LOGGER.info("Token generado para: " + user.getUsuario());
            
            return Response.ok(successResponse(token)).build();
            
        } catch (Exception e) {
            LOGGER.severe("Error crítico en login: " + e.getMessage());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                         .entity(errorResponse("Error en el servidor")).build();
        }
    }

    private HashMap<String, Object> successResponse(String token) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("token", token);
        response.put("timestamp", new Date());
        return response;
    }

    private HashMap<String, Object> errorResponse(String message) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", message);
        response.put("timestamp", new Date());
        return response;
    }
}