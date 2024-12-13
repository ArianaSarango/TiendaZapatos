package com.example.rest;

import java.util.HashMap;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import models.EstadoPago;
import models.Factura;
import controller.Dao.servicies.FacturaServicies;
import controller.tda.list.LinkedList;

@Path("factura")
public class FacturaApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFacturas() {
        HashMap map = new HashMap<>();
        FacturaServicies ps = new FacturaServicies();
        map.put("msg", "Ok");
        map.put("data", ps.ListAll().toArray());
        if (ps.ListAll().isEmpty()) {
            map.put("data", new Object[] {});

        }
        return Response.ok(map).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFacturaId(@PathParam("id") Integer id) {
        HashMap map = new HashMap<>();
        FacturaServicies ps = new FacturaServicies();
        try {
            ps.setFactura(ps.get(id));
        } catch (Exception e) {
            // TODO: handle exception
        }
        map.put("msg", "Ok");
        map.put("data", ps.getFactura());
        if (ps.getFactura().getIdFactura() == 0) {
            map.put("data", "No existe la familia con ese identificador");
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
        // Gson gson = new Gson();
        // String json = gson.toJson(map);
        // System.out.println("111111111" + json);

        try {
            FacturaServicies fs = new FacturaServicies();
            fs.getFactura().setNumeroFactura(Integer.parseInt(map.get("0").toString())); // int
            // fs.getFactura().setFechaEmision((Date) map.get("fechaEmision")); // Date
            fs.getFactura().setSubtotal(Double.parseDouble(map.get("subtotal").toString())); // double
            fs.getFactura().setIVA(Float.parseFloat(map.get("IVA").toString())); // float
            fs.getFactura().setDescuento(Float.parseFloat(map.get("descuento").toString())); // float
            fs.getFactura().setTotalFactura(Double.parseDouble(map.get("totalFactura").toString())); // double
            fs.getFactura().setEstadoPago(EstadoPago.valueOf(map.get("estadoPago").toString())); // Enum (EstadoPago)

            fs.save();
            res.put("msg", "Ok");
            res.put("data", "Guardado correctamente");
            return Response.ok(res).build();

        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    // @Path("/update")
    // @POST
    // @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response update(HashMap map) {
    //     // todo
    //     // Validation

    //     HashMap res = new HashMap<>();

    //     try {
    //         FacturaServicies fs = new FacturaServicies();
    //         fs.getFactura().setNumeroFactura(Integer.parseInt(map.get("0").toString()));
    //         // int
    //         fs.getFactura().setFechaEmision((String) map.get("fechaEmision")); // fecha de emision
    //         fs.getFactura().setSubtotal(Double.parseDouble(map.get("subtotal").toString()));
    //         // double
    //         fs.getFactura().setIVA(Float.parseFloat(map.get("IVA").toString())); // float
    //         fs.getFactura().setDescuento(Float.parseFloat(map.get("descuento").toString()));
    //         // float
    //         fs.getFactura().setTotalFactura(Double.parseDouble(map.get("totalFactura").toString()));
    //         // double
    //         fs.getFactura().setEstadoPago(EstadoPago.valueOf(map.get("estadoPago").toString()));
    //         // Enum (EstadoPago)

    //         fs.update();
    //         res.put("msg", "Ok");
    //         res.put("data", "Guardado correctamente");
    //         return Response.ok(res).build();

    //     } catch (Exception e) {
    //         res.put("msg", "Error");
    //         res.put("data", e.toString());
    //         return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
    //     }
    // }

    @Path("/listType")

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getType() {
        HashMap map = new HashMap<>();
        FacturaServicies ps = new FacturaServicies();
        map.put("msg", "Ok");
        map.put("data", ps.getFactura());
        return Response.ok(map).build();
    }

    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFactura(@PathParam("id") int id) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            FacturaServicies fs = new FacturaServicies();
            System.out.println("Intentando eliminar factura con ID: " + id);

            boolean facturadelete = fs.delete(id); // Eliminar directamente por ID

            if (facturadelete) {
                res.put("message", "Factura eliminada exitosamente");
                return Response.ok(res).build();
            } else {
                res.put("message", "Factura no encontrada o no pudo ser eliminada");
                return Response.status(Response.Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.put("message", "Error al intentar eliminar la factura");
            res.put("error", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

}
