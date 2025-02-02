package models;

public class Producto {
    private int idProducto;
    private String codigo;
    private int stock;
    private float precio;
    private String modelo;
    private String marca;
    private String talla;
    private String tipoZapato;
    private String color;

    // Constructor

    public Producto(int idProducto, int stock, float precio, String modelo, String marca, String talla, String tipoZapato, String color) {
        this.idProducto = idProducto;
        this.stock = stock;
        this.precio = precio;
        this.modelo = modelo;
        this.marca = marca;
        this.talla = talla;
        this.tipoZapato = tipoZapato;
        this.color = color;
    }

    public Producto() {
        
    }

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
}