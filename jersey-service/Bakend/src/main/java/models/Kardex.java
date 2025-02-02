package models;

public class Kardex {
    private int idKardex;
    private String registroCompra;
    private String registroVenta;
    private Producto producto;
    private String fecha;
    private listaKardex listaKardex;

    // Constructor
    
    public Kardex(int idKardex, String registroCompra, String registroVenta, Producto producto, String fecha) {
        this.idKardex = idKardex;
        this.registroCompra = registroCompra;
        this.registroVenta = registroVenta;
        this.producto = producto;
        this.fecha = fecha;
        this.listaKardex = new listaKardex();
    }

    public Kardex(){

    }

    // Getters and Setters
    public listaKardex getListaKardex() {
        return listaKardex;
    }
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
    public void setListaKardex(listaKardex listaKardex) {
        this.listaKardex = listaKardex;
    }

}
