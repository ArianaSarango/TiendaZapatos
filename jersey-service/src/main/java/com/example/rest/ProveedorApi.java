package com.example.rest;

import controller.Dao.services.ProveedorServices;
import models.Proveedor;

import java.util.HashMap;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("proveedor")
public class ProveedorApi {

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProveedores() {
        HashMap<String, Object> map = new HashMap<>();
        ProveedorServices ps = new ProveedorServices();
        map.put("msg", "Ok");
        map.put("data", ps.listAll().toArray());

        if (ps.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }

        return Response.ok(map).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProveedor(@PathParam("id") Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        ProveedorServices ps = new ProveedorServices();

        try {
            ps.setProveedor(ps.get(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("msg", "Ok");
        map.put("data", ps.getProveedor());

        if (ps.getProveedor() == null || ps.getProveedor().getId() == 0) {
            map.put("msg", "No se encontró Proveedor con ese identificador");
            return Response.status(Status.NOT_FOUND).entity(map).build();
        }

        return Response.ok(map).build();
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        ProveedorServices ps = new ProveedorServices();

        try {
            Proveedor proveedor = ps.getProveedor();
            proveedor.setNombre(map.get("nombre").toString());
            proveedor.setContacto(map.get("contacto").toString());
            proveedor.setTelefono(map.get("telefono").toString());
            proveedor.setEmail(map.get("email").toString());

            ps.save();
            res.put("msg", "Ok");
            res.put("data", "Guardado correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        ProveedorServices ps = new ProveedorServices();

        try {
            Proveedor proveedor = ps.getProveedor();
            proveedor.setNombre(map.get("nombre").toString());
            proveedor.setContacto(map.get("contacto").toString());
            proveedor.setTelefono(map.get("telefono").toString());
            proveedor.setEmail(map.get("email").toString());

            ps.update();
            res.put("msg", "Ok");
            res.put("data", "Actualizado correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            ProveedorServices ps = new ProveedorServices();
            Integer id = Integer.parseInt(map.get("id").toString());

            Boolean success = ps.delete(id);
            if (success) {
                res.put("msg", "Ok");
                res.put("data", "Eliminado correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "Proveedor no encontrado");
                return Response.status(Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}
