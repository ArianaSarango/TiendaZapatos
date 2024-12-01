package com.Practica.rest;

import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controlador.Dao.Servicios.PersonaServices;
import controlador.Dao.Servicios.UsuarioServices;

@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        HashMap<String, Object> responseMap = new HashMap<>();
        PersonaServices personaServices = new PersonaServices();
        UsuarioServices usuarioServices = new UsuarioServices();

        try {
            // Crear una instancia de Persona y guardar
            personaServices.getPersona().setIdPersona(1);
            personaServices.getPersona().setNombre("Juan");
            personaServices.getPersona().setApellido("Pérez");
            personaServices.getPersona().setDireccion("Calle Falsa 123");
            personaServices.getPersona().setTelefono("555-1234");
            personaServices.save();
            System.out.println("Persona guardada exitosamente: " + personaServices.getPersona());

            // Crear una instancia de Usuario y guardar
            usuarioServices.getUsuario().setIdUser(1);
            usuarioServices.getUsuario().setUser("juanperez");
            usuarioServices.getUsuario().setPassword("123456");
            usuarioServices.getUsuario().setEmail("juan.perez@example.com");
            usuarioServices.getUsuario().setEstado(true);
            usuarioServices.save();
            System.out.println("Usuario guardado exitosamente: " + usuarioServices.getUsuario());

            // Verificar si las listas no están vacías
            boolean personasVacias = personaServices.ListAll().isEmpty();
            boolean usuariosVacios = usuarioServices.ListAll().isEmpty();

            responseMap.put("msg", "Operación exitosa");
            responseMap.put("data", "Datos guardados correctamente.");
            responseMap.put("personasVacias", personasVacias);
            responseMap.put("usuariosVacios", usuariosVacios);
            responseMap.put("personasGuardadas", personaServices.ListAll());
            responseMap.put("usuariosGuardados", usuarioServices.ListAll());

        } catch (Exception e) {
            System.err.println("Error al procesar los datos: " + e.getMessage());
            responseMap.put("msg", "Error");
            responseMap.put("data", "Error al guardar datos: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseMap).build();
        }

        return Response.ok(responseMap).build();
    }
}
