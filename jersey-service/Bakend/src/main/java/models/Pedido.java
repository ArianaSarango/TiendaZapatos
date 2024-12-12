package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido {
    private int id;
    private Producto producto;
    private int cantidadSolicitada;
<<<<<<< HEAD
    private String fechaPedido;
    private String fecha;
=======
    private Date fechaPedido;
    private Date fecha;
>>>>>>> origin/Juan
    private Proveedor proveedor;
    private boolean recibido;

    public Pedido() {}

    public Pedido(int id, Producto producto, int cantidadSolicitada, Date fechaPedido, Date fecha, Proveedor proveedor, boolean recibido) {
        this.id = id;
        this.producto = producto;
        this.cantidadSolicitada = cantidadSolicitada;
        this.fechaPedido = fechaPedido;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.recibido = recibido;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public int getCantidadSolicitada() { return cantidadSolicitada; }
    public void setCantidadSolicitada(int cantidadSolicitada) { this.cantidadSolicitada = cantidadSolicitada; }

    public Date getFechaPedido() {
        return fechaPedido;
    }
    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    public void setFechaPedidoFromString(String fechaStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.fechaPedido = dateFormat.parse(fechaStr);
    }
    
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    public boolean isRecibido() { return recibido; }
    public void setRecibido(boolean recibido) { this.recibido = recibido; }
}
