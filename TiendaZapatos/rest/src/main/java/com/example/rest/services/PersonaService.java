package com.example.rest.services;

import com.example.rest.dao.PersonaDao;
import com.example.rest.dao.implement.PersonaDaoImpl;
import com.example.rest.model.Persona;

public class PersonaService {
    private final PersonaDao personaDao = new PersonaDaoImpl();

    public void agregarPersona(Persona persona) {
        personaDao.agregarPersona(persona);
    }

    public Persona[] obtenerTodasLasPersonas() {
        return personaDao.obtenerTodasLasPersonas();
    }
}
