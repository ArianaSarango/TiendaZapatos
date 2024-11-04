package com.example.rest.controller;

import com.example.rest.model.Persona;
import com.example.rest.services.PersonaService;

public class PersonaController {
    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    public void crearPersona(Persona persona) {
        personaService.addPersona(persona);
    }

    public Persona obtenerPersonaPorId(int id) {
        return personaService.getPersonaById(id);
    }

    public void eliminarPersona(int id) {
        personaService.deletePersona(id);
    }


}
