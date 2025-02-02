package com.example.rest;

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

import controller.Dao.servicies.PersonaServices;
import models.Persona;
import models.TipoIdentificacion;

@Path("persona")
public class PersonaApi {

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersonas() {
        HashMap<String, Object> map = new HashMap<>();
        PersonaServices ps = new PersonaServices();
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
    public Response getPersona(@PathParam("id") Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        PersonaServices ps = new PersonaServices();

        try {
            ps.setPersona(ps.get(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("msg", "Ok");
        map.put("data", ps.getPersona());

        if (ps.getPersona() == null || ps.getPersona().getIdPersona() == 0) {
            map.put("msg", "No se encontró Persona con ese identificador");
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
        PersonaServices ps = new PersonaServices();
    
        try {
            // Validar que los parámetros no sean nulos
            if (map.get("nombre") == null || map.get("apellido") == null || map.get("tipoIdentificacion") == null || map.get("numeroIdentificacion") == null) {
                res.put("msg", "Error");
                res.put("data", "Parámetros requeridos están vacíos");
                return Response.status(Status.BAD_REQUEST).entity(res).build();
            }
    
            Persona persona = ps.getPersona();
            persona.setNombre(map.get("nombre").toString());
            persona.setApellido(map.get("apellido").toString());
            
            // Convertir el String a TipoIdentificacion
            TipoIdentificacion tipoIdentificacion = ps.getTipoIdentificacion(map.get("tipoIdentificacion").toString());
            persona.setTipoIdentificacion(tipoIdentificacion);
            persona.setNumeroIdentificacion(map.get("numeroIdentificacion").toString());
            persona.setDireccion(map.get("direccion").toString());
            persona.setTelefono(map.get("telefono").toString());
    
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
    


    
    
    

    @Path("/delete/{id}")
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response delete(@PathParam("id") Integer id) {
    HashMap<String, Object> res = new HashMap<>();

    try {
        PersonaServices ps = new PersonaServices();
        Boolean success = ps.delete(id);
        if (success) {
            res.put("msg", "Ok");
            res.put("data", "Persona eliminada correctamente");
            return Response.ok(res).build();
        } else {
            res.put("msg", "Error");
            res.put("data", "Persona no encontrada");
            return Response.status(Status.NOT_FOUND).entity(res).build();
        }
    } catch (Exception e) {
        res.put("msg", "Error");
        res.put("data", e.toString());
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
    }
}

    

    @Path("/list/search/ident/factura/{texto}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonasIdentFactura(@PathParam("texto") String texto) {
        HashMap map = new HashMap<>();
        PersonaServices ps = new PersonaServices();
        map.put("msg", "Ok");
        map.put("data", ps.buscar_identificacion_factura(texto));

        if (map.isEmpty()) {
            map.put("msg", "No existe la persona");
            return Response.status(Status.BAD_REQUEST).header("Access-Control-Allow-Origin", "*").entity(map).build();
        }
        return Response.ok(map).header("Access-Control-Allow-Origin", "*").build();


    }
}
