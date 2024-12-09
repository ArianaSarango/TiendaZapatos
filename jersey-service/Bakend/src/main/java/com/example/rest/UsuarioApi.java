package com.example.rest;

import controller.Dao.servicies.UsuarioServices; // Asegúrate de que este paquete sea correcto
import models.Usuario; // Asegúrate de que este paquete sea correcto

import java.util.HashMap;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("usuario")
public class UsuarioApi {

    // Ruta para listar todos los usuarios
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsuarios() {
        HashMap<String, Object> map = new HashMap<>();
        UsuarioServices us = new UsuarioServices();
        map.put("msg", "Ok");
        map.put("data", us.ListAll().toArray());

        if (us.ListAll().isEmpty()) {
            map.put("data", new Object[] {});
        }

        return Response.ok(map).build();
    }

    // Ruta para obtener un usuario por ID
    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        UsuarioServices us = new UsuarioServices();

        try {
            us.setUsuario(us.get(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("msg", "Ok");
        map.put("data", us.getUsuario());

        if (us.getUsuario() == null || us.getUsuario().getIdUser() == 0) {
            map.put("msg", "No se encontró Usuario con ese identificador");
            return Response.status(Status.NOT_FOUND).entity(map).build();
        }

        return Response.ok(map).build();
    }

    // Ruta para guardar un nuevo usuario
    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        UsuarioServices us = new UsuarioServices();

        try {
            Usuario usuario = us.getUsuario();
            usuario.setUser(map.get("user").toString());
            usuario.setPassword(map.get("password").toString());
            usuario.setEmail(map.get("email").toString());
            usuario.setEstado(Boolean.parseBoolean(map.get("estado").toString()));

            us.save();
            res.put("msg", "Ok");
            res.put("data", "Guardado correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    // Ruta para actualizar un usuario existente
    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        UsuarioServices us = new UsuarioServices();

        try {
            Usuario usuario = us.getUsuario();
            usuario.setUser(map.get("user").toString());
            usuario.setPassword(map.get("password").toString());
            usuario.setEmail(map.get("email").toString());
            usuario.setEstado(Boolean.parseBoolean(map.get("estado").toString()));

            us.update();
            res.put("msg", "Ok");
            res.put("data", "Actualizado correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    // Ruta para eliminar un usuario por ID
    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            UsuarioServices us = new UsuarioServices();
            Integer id = Integer.parseInt(map.get("id").toString());

            Boolean success = us.delete(id);
            if (success) {
                res.put("msg", "Ok");
                res.put("data", "Usuario eliminado correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "Usuario no encontrado");
                return Response.status(Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}
