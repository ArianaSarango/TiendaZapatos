package models;

import java.util.List;

public class Kardex {
    private int idKardex;
    private String registroCompra;
    private String registroVenta;
    private Producto producto;
    private String fecha;

    // Relación 1 a muchos Kardex → Pedido
    private List<Pedido> pedidos;

    // Constructor
    public Kardex(int idKardex, String registroCompra, String registroVenta, Producto producto, String fecha, List<Pedido> pedidos) {
        this.idKardex = idKardex;
        this.registroCompra = registroCompra;
        this.registroVenta = registroVenta;
        this.producto = producto;
        this.fecha = fecha;
        this.pedidos = pedidos;  // Corrección aquí
    }

    public Kardex() {
    }

    // Getters y Setters
    public int getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(int idKardex) {
        this.idKardex = idKardex;
    }

    public String getRegistroCompra() {
        return registroCompra;
    }

    public void setRegistroCompra(String registroCompra) {
        this.registroCompra = registroCompra;
    }

    public String getRegistroVenta() {
        return registroVenta;
    }

    public void setRegistroVenta(String registroVenta) {
        this.registroVenta = registroVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Pedido> getPedidos() {  // Corrección en el nombre del método
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {  // Corrección en el nombre del método
        this.pedidos = pedidos;
    }
}
