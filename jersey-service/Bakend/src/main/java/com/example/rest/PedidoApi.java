package com.example.rest;

import controller.Dao.servicies.PedidoServices;
import models.Pedido;
import java.util.HashMap;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("pedido")
public class PedidoApi {

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPedidos() {
        HashMap<String, Object> res = new HashMap<>();
        PedidoServices ps = new PedidoServices();

        try {
            res.put("msg", "Ok");
            res.put("data", ps.listAll().toArray());

            if (ps.listAll().isEmpty()) {
                res.put("data", new Object[]{});
            }

            return Response.ok(res).build();
        } catch (Exception e) {
            e.printStackTrace();
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPedido(@PathParam("id") Integer id) {
        HashMap<String, Object> res = new HashMap<>();
        PedidoServices ps = new PedidoServices();

        try {
            Pedido pedido = ps.get(id);
            if (pedido == null) {
                res.put("msg", "No se encontró pedido con ese identificador");
                return Response.status(Status.NOT_FOUND).entity(res).build();
            }

            res.put("msg", "Ok");
            res.put("data", pedido);
            return Response.ok(res).build();
        } catch (Exception e) {
            e.printStackTrace();
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        PedidoServices ps = new PedidoServices();
        Pedido pedido = new Pedido();

        try {
            pedido.setCantidadSolicitada(Integer.parseInt(map.get("cantidadSolicitada").toString()));
            // pedido.setFechaPedido(map.get("fechaPedido").toString());
            // pedido.setFecha(map.get("fecha").toString());
            pedido.setRecibido(Boolean.parseBoolean(map.get("recibido").toString()));

            ps.setPedido(pedido);
            ps.save();

            res.put("msg", "Ok");
            res.put("data", "Guardado correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            e.printStackTrace();
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
        PedidoServices ps = new PedidoServices();

        try {
            Pedido pedido = ps.getPedido();
            pedido.setCantidadSolicitada(Integer.parseInt(map.get("cantidadSolicitada").toString()));
            // pedido.setFechaPedido(map.get("fechaPedido").toString());
            // pedido.setFecha(map.get("fecha").toString());
            pedido.setRecibido(Boolean.parseBoolean(map.get("recibido").toString()));

            ps.update();
            res.put("msg", "Ok");
            res.put("data", "Actualizado correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            e.printStackTrace();
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            PedidoServices ps = new PedidoServices();
            System.out.println("Intentando eliminar pedido con ID: " + id);

            boolean pedidodelete = ps.delete(id); // Eliminar directamente por ID

            if (pedidodelete) {
                res.put("message", "Pedido eliminada exitosamente");
                return Response.ok(res).build();
            } else {
                res.put("message", "Pedido no encontrada o no pudo ser eliminada");
                return Response.status(Response.Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.put("message", "Error al intentar eliminar la pedido");
            res.put("error", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

}
