package com.example.rest.main;

import com.example.rest.model.Persona;
import com.example.rest.model.TipoIdentificacion;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Persona
        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Juan");
        persona.setApellido("Pérez");
        persona.setTipoIdentificacion(TipoIdentificacion.CEDULA);
        persona.setNumeroIdentificacion("1234567890");
        persona.setDireccion("Calle Falsa 123");
        persona.setTelefono("0987654321");

        // Convertir el objeto Persona a JSON
        Gson gson = new Gson();
        String personaJson = gson.toJson(persona);
        System.out.println("JSON de Persona: " + personaJson);

        // Convertir JSON de vuelta a un objeto Persona
        Persona personaFromJson = gson.fromJson(personaJson, Persona.class);
        System.out.println("Objeto Persona a partir de JSON: " + personaFromJson.getNombre() + " " + personaFromJson.getApellido());
    }
}
