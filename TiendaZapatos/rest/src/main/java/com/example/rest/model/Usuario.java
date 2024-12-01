package com.example.rest.model;

public class Usuario extends Persona {
    private String username;
    private String password;

    public Usuario(int id, String nombre, String apellido, TipoIdentificacion tipoIdentificacion, String numeroIdentificacion, String direccion, String telefono, String username, String password) {
        super(id, nombre, apellido, tipoIdentificacion, numeroIdentificacion, direccion, telefono);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
