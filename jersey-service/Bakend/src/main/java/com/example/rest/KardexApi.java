package com.example.rest;

import controller.Dao.servicies.KardexServices;

import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

@Path("kardex")
public class KardexApi {

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllKardexs() {
        HashMap<String, Object> map = new HashMap<>();
        KardexServices ps = new KardexServices();
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
    public Response getKardex(@PathParam("id") Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        KardexServices ps = new KardexServices();
        
        try {
            ps.setKardex(ps.get(id));
        } catch (Exception e) {
            e.printStackTrace(); // Opcional: para diagnosticar errores
        }

        map.put("msg", "Ok");
        map.put("data", ps.getKardex());

        if (ps.getKardex() == null || ps.getKardex().getIdKardex() == 0) {
            map.put("msg", "No se encontró Kardex con ese identificador");
            return Response.status(Status.NOT_FOUND).entity(map).build();
        }

        if (ps.listAll().isEmpty()) {
            map.put("data", new Object[] {});
            return Response.status(Status.BAD_REQUEST).entity(map).build();
        }

        return Response.ok(map).build();
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        Gson g = new Gson();
        String a = g.toJson(map);
        System.out.println("***** " + a);

        try {
            KardexServices ps = new KardexServices();
            ps.getKardex().setRegistroCompra(map.get("registroCompra").toString());
            ps.getKardex().setRegistroVenta(map.get("registroVenta").toString());
            ps.getKardex().setProducto(null);
            ps.getKardex().setFecha(null);

            ps.save();
            res.put("msg", "Ok");
            res.put("data", "Guardado correctamente");
            return Response.ok(res).build();

        } catch (Exception e) {
            System.out.println("Error en save data: " + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/listType")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getType() {
        HashMap<String, Object> map = new HashMap<>();
        KardexServices ps = new KardexServices();
        map.put("msg", "Ok");
        map.put("data", ps.getKardex());
        
        return Response.ok(map).build();
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            KardexServices ps = new KardexServices();
            ps.getKardex().setRegistroCompra(map.get("registroCompra").toString());
            ps.getKardex().setRegistroVenta(map.get("registroVenta").toString());
            ps.getKardex().setProducto(null);
            ps.getKardex().setFecha(null);

            ps.update();
            res.put("msg", "Ok");
            res.put("data", "Actualizado correctamente");
            return Response.ok(res).build();

        } catch (Exception e) {
            System.out.println("Error en update data: " + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteKardex(@PathParam("id") int id) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            KardexServices ps = new KardexServices();
            System.out.println("Intentando eliminar kardex con ID: " + id);

            boolean kardexdelete = ps.delete(id); // Eliminar directamente por ID

            if (kardexdelete) {
                res.put("message", "Kardex eliminada exitosamente");
                return Response.ok(res).build();
            } else {
                res.put("message", "Kardex no encontrada o no pudo ser eliminada");
                return Response.status(Response.Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.put("message", "Error al intentar eliminar la kardex");
            res.put("error", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}