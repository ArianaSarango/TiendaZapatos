package models;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.tda.list.LinkedList;

public class Pedido {
    private int id;
    private Producto producto;
    private int cantidadSolicitada;
    private String fechaPedido;
    private String fecha;
    private Proveedor proveedor;
    private boolean recibido;

    //relacion muchos a muchos pedidos --> productos
    private LinkedList<Producto> productos;

    public Pedido() {}

    public Pedido(int id, Producto producto, int cantidadSolicitada, String fechaPedido, String fecha,
            Proveedor proveedor, boolean recibido, LinkedList<Producto> productos) {
        this.id = id;
        this.producto = producto;
        this.cantidadSolicitada = cantidadSolicitada;
        this.fechaPedido = fechaPedido;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.recibido = recibido;
        this.productos = productos;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public int getCantidadSolicitada() { return cantidadSolicitada; }
    public void setCantidadSolicitada(int cantidadSolicitada) { this.cantidadSolicitada = cantidadSolicitada; }

    public String getFechaPedido() {
        return fechaPedido;
    }
    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    public void setFechaPedidoFromDate(Date fechaStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.fechaPedido = dateFormat.format(fechaStr); 
    }    
    
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    public boolean isRecibido() { return recibido; }
    public void setRecibido(boolean recibido) { this.recibido = recibido; }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

    
}
