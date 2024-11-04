package modelo;

public class DetalleFactura {
    private int id;
    private int idProducto;
    private Double precioProducto;
    //private Persona cliente;
    private int cantidadProductos;
    private int idDetalleFactura;

    // constructor

    public DetalleFactura(int id, int idProducto, Double precioProducto, /*Persona cliente,*/ int cantidadProductos){
        this.idProducto = idProducto;
        this.precioProducto = precioProducto;
        //this.cliente = cliente;
        this.cantidadProductos = cantidadProductos;
        this.id = id;

    }

    public DetalleFactura() {
    }

    // getters and setters

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Double getPrecioProducto() {
        return this.precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    /*public Persona getCliente() {
        return this.cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }*/

    public int getCantidadProductos() {
        return this.cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }
    
}
