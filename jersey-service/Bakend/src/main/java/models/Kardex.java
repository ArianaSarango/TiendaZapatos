package models;

import java.util.List;

public class Kardex {
    private int idKardex;
    private String registroCompra;
    private String registroVenta;
    private Producto producto;
    private String fecha;
    

    // Constructor
    
    public Kardex(int idKardex, String registroCompra, String registroVenta, Producto producto, String fecha) {

        this.idKardex = idKardex;
        this.registroCompra = registroCompra;
        this.registroVenta = registroVenta;
        this.producto = producto;
        this.fecha = fecha;
<<<<<<< HEAD

        this.listaKardex = new listaKardex();
 
=======
        
>>>>>>> origin/Juan
    }

    public Kardex() {
    }

    // Getters and Setters
<<<<<<< HEAD
    public listaKardex getListaKardex() {
        return listaKardex;
    }

=======
   
>>>>>>> origin/Juan
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
<<<<<<< HEAD


    public List<Pedido> getPedidos() {  // Corrección en el nombre del método
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {  // Corrección en el nombre del método
        this.pedidos = pedidos;
    }

    public void setListaKardex(listaKardex listaKardex) {
        this.listaKardex = listaKardex;
    }
=======
   
>>>>>>> origin/Juan

 
}
