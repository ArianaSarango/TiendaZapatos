package com.example.rest;

import controller.Dao.servicies.DetalleFacturaServicies;
import controller.Dao.servicies.ProductoServices;
import models.EstadoPago;

import java.util.HashMap;
import java.util.Date;
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
import javax.ws.rs.core.Response.StatusType;

import com.google.gson.Gson;

@Path("detalleFactura")
public class DetalleFacturaApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        HashMap map = new HashMap<>();
        DetalleFacturaServicies ps = new DetalleFacturaServicies();
        map.put("msg", "Ok");
        map.put("data", ps.ListAll().toArray());
        if (ps.ListAll().isEmpty()) {
            map.put("data", new Object[] {});

        }
        return Response.ok(map).build();
    }

    @Path("/get.id")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") Integer id) {
        HashMap map = new HashMap<>();
        DetalleFacturaServicies ps = new DetalleFacturaServicies();
        try {
            ps.setDetalleFactura(ps.getDetalleFactura());
        } catch (Exception e) {
            // TODO: handle exception
        }
        map.put("msg", "Ok");
        map.put("data", ps.getDetalleFactura());
        if (ps.getDetalleFactura().getId() == 0) {
            map.put("data", "No existe este detalle de factura");
            return Response.status(Status.BAD_REQUEST).entity(map).build();
        }

        return Response.ok(map).build();
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap map) {
        // todo
        // Validation

        HashMap res = new HashMap<>();
        Gson g = new Gson();
        String a = g.toJson(map);

        try {

            if (map.get("device")!= null && map.get("details") != null) {
                ProductoServices ps = new ProductoServices();
                ps.setProducto(ps.get(Integer.parseInt(map.get("device").toString())));
            }

            DetalleFacturaServicies dfs = new DetalleFacturaServicies();

            dfs.getDetalleFactura().setId(Integer.parseInt(map.get("id").toString())); // int
            dfs.getDetalleFactura().setIdProducto(Integer.parseInt(map.get("idProducto").toString())); // int
            dfs.getDetalleFactura().setPrecioProducto(Double.parseDouble(map.get("precioProducto").toString())); // Double
            dfs.getDetalleFactura().setCantidadProductos(Integer.parseInt(map.get("cantidadProductos").toString())); // int

            dfs.save();
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
    public Response update(HashMap map) {
        // todo
        // Validation

        HashMap res = new HashMap<>();

        try {
            DetalleFacturaServicies dfs = new DetalleFacturaServicies();

            dfs.getDetalleFactura().setId(Integer.parseInt(map.get("id").toString())); // int
            dfs.getDetalleFactura().setIdProducto(Integer.parseInt(map.get("idProducto").toString())); // int
            dfs.getDetalleFactura().setPrecioProducto(Double.parseDouble(map.get("precioProducto").toString())); // Double
            dfs.getDetalleFactura().setCantidadProductos(Integer.parseInt(map.get("cantidadProductos").toString())); // int

            dfs.save();
            res.put("msg", "Ok");
            res.put("data", "Detalle guardado correctamente");
            return Response.ok(res).build();

        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/listType")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getType() {
        HashMap map = new HashMap<>();
        DetalleFacturaServicies ps = new DetalleFacturaServicies();
        map.put("msg", "Ok");
        map.put("data", ps.getDetalleFactura());
        return Response.ok(map).build();
    }

}
