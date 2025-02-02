package models;

import controller.tda.list.LinkedList;

public class Producto {
    private int idProducto;
    private String codigo;
    private int stock;
    private float precio;
    private String modelo;
    private String talla;
    private String tipoZapato;
    private String color;
    private Marca marca;

    //relacion muchos a muchos pedidos --> productos
    private LinkedList<Pedido> pedidos; 

<<<<<<< HEAD
    // Constructor
    public Producto(int idProducto, int stock, float precio, String modelo, String marca, String talla,
        String tipoZapato, String color, LinkedList<Pedido> pedidos) {
=======
    public Producto(int idProducto, int stock, float precio, String modelo, String talla, String tipoZapato, String color, Marca marca) {
>>>>>>> origin/Juan
        this.idProducto = idProducto;
        this.stock = stock;
        this.precio = precio;
        this.modelo = modelo;
        this.talla = talla;
        this.tipoZapato = tipoZapato;
        this.color = color;
<<<<<<< HEAD
        this.pedidos = pedidos;
=======
        this.marca = marca;
    }

    // Getters and Setters
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getTipoZapato() {
        return tipoZapato;
    }

    public void setTipoZapato(String tipoZapato) {
        this.tipoZapato = tipoZapato;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
>>>>>>> origin/Juan
    }

    public Producto() {
        
    }
<<<<<<< HEAD

    // Getters and Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getTalla() {
        return talla;
    }
    public void setTalla(String talla) {
        this.talla = talla;
    }
    public String getTipoZapato() {
        return tipoZapato;
    }
    public void setTipoZapato(String tipoZapato) {
        this.tipoZapato = tipoZapato;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
<<<<<<< HEAD

    public LinkedList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(LinkedList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    

=======
=======
  
>>>>>>> origin/Juan
>>>>>>> origin/Juan
}