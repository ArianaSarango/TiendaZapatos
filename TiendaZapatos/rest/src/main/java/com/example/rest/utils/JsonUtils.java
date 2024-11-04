package com.example.rest.utils;

import com.example.rest.model.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonUtils {
    private static final String FILE_PATH = "C:/Users/patri/OneDrive/Escritorio/TiendaZapatos/rest/src/main/resources/personas.json";
    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void guardarPersonasEnJson(Persona[] personas, int cantidad) {
        try {
            Persona[] personasGuardadas = new Persona[cantidad];
            System.arraycopy(personas, 0, personasGuardadas, 0, cantidad);
            mapper.writeValue(new File(FILE_PATH), personasGuardadas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
