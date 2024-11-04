package com.example.rest.dao.implement;

import com.example.rest.dao.PersonaDao;
import com.example.rest.model.Persona;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoImpl implements PersonaDao {
    private List<Persona> personas = new ArrayList<>();

    @Override
    public void save(Persona persona) {
        personas.add(persona);
    }

    @Override
    public Persona getById(int id) {
        return personas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Persona> getAll() {
        return personas;
    }

    @Override
    public void update(Persona persona) {
    
    }

    @Override
    public void delete(int id) {
        personas.removeIf(p -> p.getId() == id);
    }
}
