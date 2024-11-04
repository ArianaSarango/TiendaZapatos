package com.example.rest.services;

import com.example.rest.dao.PersonaDao;
import com.example.rest.model.Persona;
import java.util.List;

public class PersonaService {
    private PersonaDao personaDao;

    public PersonaService(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    public void addPersona(Persona persona) {
        personaDao.save(persona);
    }

    public Persona getPersonaById(int id) {
        return personaDao.getById(id);
    }

    public List<Persona> getAllPersonas() {
        return personaDao.getAll();
    }

    public void updatePersona(Persona persona) {
        personaDao.update(persona);
    }

    public void deletePersona(int id) {
        personaDao.delete(id);
    }
}
