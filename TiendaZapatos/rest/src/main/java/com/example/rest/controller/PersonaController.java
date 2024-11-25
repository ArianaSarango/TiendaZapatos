package com.example.rest.controller;

import com.example.rest.model.Persona;
import com.example.rest.model.TipoIdentificacion;
import com.example.rest.services.PersonaService;

public class PersonaController {
    private final PersonaService personaService = new PersonaService();

    public void crearPersona(int id, String nombre, String apellido, TipoIdentificacion tipoIdentificacion, String numeroIdentificacion, String direccion, String telefono) {
        Persona persona = new Persona(id, nombre, apellido, tipoIdentificacion, numeroIdentificacion, direccion, telefono);
        personaService.agregarPersona(persona);
    }

    public void mostrarPersonas() {
        Persona[] personas = personaService.obtenerTodasLasPersonas();
        for (Persona persona : personas) {
            System.out.println("ID: " + persona.getId() + ", Nombre: " + persona.getNombre() + ", Apellido: " + persona.getApellido());
        }
    }
}
