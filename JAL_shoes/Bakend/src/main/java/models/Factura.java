package models;

import java.util.Date;

public class Factura {
    private Integer id;
    private Date fechaEmision;
    private String numeroFactura;
    private float IVA;
    private Double subtotal;
    private Double totalFactura;
    private EstadoPago estadoPago;
    private String codProducto;


    // constructor

    // public Factura( Integer idFactura, int numeroFactura, Date fechaEmision, Double subtotal, float IVA, float descuento, Double totalFactura, EstadoPago estadoPago){
    //     this.idFactura = idFactura;
    //     this.numeroFactura = numeroFactura;
    //     this.fechaEmision = fechaEmision;
    //     this.subtotal = subtotal;
    //     this.IVA = IVA;
    //     this.descuento = descuento;
    //     this.totalFactura = totalFactura;
    //     this.estadoPago = estadoPago;
    // }

    public Factura() {
    }

    // getters and setters

    public int getIdFactura() {
        return this.id;
    }

    public void setIdFactura(Integer id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return this.numeroFactura;
    }
    
    public String getcodProducto() {
        return this.codProducto;
    }

    public void setcodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaEmision() {
        return this.fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Double getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public float getIVA() {
        return this.IVA;
    }

    public void setIVA(float IVA) {
        this.IVA = IVA;
    }

    public Double getTotalFactura() {
        return this.totalFactura;
    }

    public void setTotalFactura(Double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public EstadoPago getEstadoPago() {
        return this.estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }
    

}
