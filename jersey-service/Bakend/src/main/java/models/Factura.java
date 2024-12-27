package models;

import java.util.Date;

public class Factura {
    private Integer idFactura;
    private Persona persona;
    private int numeroFactura;
    private Date fechaEmision;
    private Double subtotal;
    private float IVA;
    private float descuento;
    private Double totalFactura;
    private EstadoPago estadoPago;

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
        return this.idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getIdPersona() {
        return persona.getIdPersona();
    }

    public int getNumeroFactura() {
        return this.numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
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

    public float getDescuento() {
        return this.descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
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
