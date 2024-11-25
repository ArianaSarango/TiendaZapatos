package com.example.rest.main;

import com.example.rest.controller.PersonaController;
import com.example.rest.model.TipoIdentificacion;

public class Main {
    public static void main(String[] args) {
        PersonaController controller = new PersonaController();

        // Agregar personas
        controller.crearPersona(1, "Juan", "Pérez", TipoIdentificacion.CEDULA, "1234567890", "Calle Falsa 123", "0987654321");
        controller.crearPersona(2, "Ana", "Gómez", TipoIdentificacion.PASAPORTE, "A987654321", "Avenida Siempre Viva 456", "0123456789");

        // Mostrar personas
        controller.mostrarPersonas();
    }
}
