package models;

import java.util.Objects;

import controller.tda.list.LinkedList;

public class Proveedor {
    private int id;
    private String nombre;
    private String contacto;
    private String telefono;
    private String email;

    //relacion 1 a muchos proveedor --> pedidos
    private LinkedList<Pedido> pedidos;

    public Proveedor() {}

    public Proveedor(int id, String nombre, String contacto, String telefono, String email,
            LinkedList<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.email = email;
        this.pedidos = pedidos;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { 
        if (telefono != null && telefono.length() == 10) { 
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("Número de teléfono inválido");
        }
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { 
        if (email != null && email.contains("@")) { 
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido");
        }
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contacto='" + contacto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return id == proveedor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public LinkedList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(LinkedList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
