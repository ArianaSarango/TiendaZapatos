package com.example.rest;

import controller.Dao.servicies.ProductoServices;

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

    @Path("/code/{codigo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductosBycode(@PathParam("codigo")String codigo) {
        HashMap map = new HashMap<>();
        ProductoServices ps = new ProductoServices();
        try {
            ps.setProducto(ps.get_Producto_Codigo(codigo));
        } catch (Exception e) {
            //TODO: handle exception
        }
        map.put("msg", "Ok");
        map.put("data", ps.getProducto());
        if (ps.getProducto().getCodigo() == null) {
            map.put("dta", "No existe producto con ese codigo");
            return Response.status(Status.BAD_REQUEST).header("Access-Control-Allow-Origin","*").entity(map).build();
            
        }
        return Response.ok(map).header("Access-Control-Allow-Origin","*").build();

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
            ps.getProducto().setCodigo(map.get("codigo").toString());
            ps.getProducto().setColor(map.get("color").toString());
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
            ps.getProducto().setCodigo(map.get("codigo").toString());
            ps.getProducto().setColor(map.get("color").toString());
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

    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProducto(@PathParam("id") int id) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            ProductoServices ps = new ProductoServices();
            System.out.println("Intentando eliminar producto con ID: " + id);

            boolean productodelete = ps.delete(id); // Eliminar directamente por ID

            if (productodelete) {
                res.put("message", "producto eliminada exitosamente");
                return Response.ok(res).build();
            } else {
                res.put("message", "producto no encontrada o no pudo ser eliminada");
                return Response.status(Response.Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.put("message", "Error al intentar eliminar la producto");
            res.put("error", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}