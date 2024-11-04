package com.example.rest.dao.implement;

import com.example.rest.dao.PersonaDao;
import com.example.rest.model.Persona;
import com.example.rest.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class PersonaDaoImpl implements PersonaDao {
    private Persona[] personas = new Persona[100];
    private int contador = 0;

    @Override
    public void agregarPersona(Persona persona) {
        if (contador < personas.length) {
            personas[contador++] = persona;
            JsonUtils.guardarPersonasEnJson(personas, contador);
        }
    }

    @Override
    public Persona[] obtenerTodasLasPersonas() {
        Persona[] personasActivas = new Persona[contador];
        System.arraycopy(personas, 0, personasActivas, 0, contador);
        return personasActivas;
    }
}
