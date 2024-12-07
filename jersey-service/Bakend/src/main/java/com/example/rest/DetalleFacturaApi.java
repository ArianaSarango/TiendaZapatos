package com.example.rest;

import controller.Dao.servicies.DetalleFacturaServicies;
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

        try {

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

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFamilia(@PathParam("id") int id) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            DetalleFacturaServicies fs = new DetalleFacturaServicies();

            // Intentar eliminar la familia
            boolean facturadelete = fs.delete(id - 1);

            if (facturadelete) {
                res.put("message", "Detalle de factura eliminado exitosamente");
                return Response.ok(res).build();
            } else {
                // Si no se eliminó, enviar un error 404
                res.put("message", "Detalle de factura no encontrado o no eliminado");
                return Response.status(Response.Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            // En caso de error, devolver una respuesta de error interno
            res.put("message", "Error al intentar eliminar el detalle de factura");
            res.put("error", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

}
