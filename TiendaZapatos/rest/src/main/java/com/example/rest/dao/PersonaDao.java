package com.example.rest.dao;

import com.example.rest.model.Persona;
import java.util.List;

public interface PersonaDao {
    void save(Persona persona);
    Persona getById(int id);
    List<Persona> getAll();
    void update(Persona persona);
    void delete(int id);
}
