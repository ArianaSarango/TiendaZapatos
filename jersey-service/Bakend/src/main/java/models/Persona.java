package models;

import controller.tda.list.LinkedList;

public class Persona {
    private int idPersona;
    private String nombre;
    private String apellido;
    private TipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;
    private String direccion;
    private String telefono;

    //relacion 1 a muchos persona --> facturas
    private LinkedList<Factura> listaFacturas;

    // Constructor vacío
    public Persona() {}

    // Constructor completo
    public Persona(int idPersona, String nombre, String apellido, TipoIdentificacion tipoIdentificacion,
            String numeroIdentificacion, String direccion, String telefono, LinkedList<Factura> listaFacturas) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaFacturas = listaFacturas;
    }

    // Getters y setters con validaciones
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        if (tipoIdentificacion == null) {
            throw new IllegalArgumentException("El tipo de identificación no puede ser nulo");
        }
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LinkedList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(LinkedList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
}
