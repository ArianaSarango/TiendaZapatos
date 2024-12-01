package com.example.rest.dao;

import com.example.rest.model.Persona;

public interface PersonaDao {
    void agregarPersona(Persona persona);
    Persona[] obtenerTodasLasPersonas();
}
