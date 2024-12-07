package com.example.rest;

import controller.Dao.servicies.ProductoServices;

import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

@Path("producto")
public class ProductoApi {

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProductos() {
        HashMap<String, Object> map = new HashMap<>();
        ProductoServices ps = new ProductoServices();
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
    public Response getProducto(@PathParam("id") Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        ProductoServices ps = new ProductoServices();
        
        try {
            ps.setProducto(ps.get(id));
        } catch (Exception e) {
            e.printStackTrace(); // Opcional: para diagnosticar errores
        }

        map.put("msg", "Ok");
        map.put("data", ps.getProducto());

        if (ps.getProducto() == null || ps.getProducto().getIdProducto() == 0) {
            map.put("msg", "No se encontró Producto con ese identificador");
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
            ProductoServices ps = new ProductoServices();
            ps.getProducto().setColor(null);
            ps.getProducto().setMarca(map.get("marca").toString());
            ps.getProducto().setModelo(map.get("modelo").toString());
            ps.getProducto().setPrecio(Float.parseFloat(map.get("precio").toString()));
            ps.getProducto().setStock(Integer.parseInt(map.get("stock").toString()));
            ps.getProducto().setTalla(map.get("talla").toString());
            ps.getProducto().setTipoZapato(map.get("tipoZapato").toString());

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
        ProductoServices ps = new ProductoServices();
        map.put("msg", "Ok");
        map.put("data", ps.getProducto());
        
        return Response.ok(map).build();
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            ProductoServices ps = new ProductoServices();
            ps.getProducto().setColor(null);
            ps.getProducto().setMarca(map.get("marca").toString());
            ps.getProducto().setModelo(map.get("modelo").toString());
            ps.getProducto().setPrecio(Float.parseFloat(map.get("precio").toString()));
            ps.getProducto().setStock(Integer.parseInt(map.get("stock").toString()));
            ps.getProducto().setTalla(map.get("talla").toString());
            ps.getProducto().setTipoZapato(map.get("tipoZapato").toString());

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

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            ProductoServices ps = new ProductoServices();
            Integer id = Integer.parseInt(map.get("idProducto").toString());
            
            Boolean success = ps.delete(id);
            if (success) {
                res.put("msg", "Ok");
                res.put("data", "Eliminado correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "Producto no encontrada");
                return Response.status(Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            System.out.println("Error en delete data: " + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}