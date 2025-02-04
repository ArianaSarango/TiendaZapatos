package models;

import java.sql.Date;
import java.util.UUID;

public class DetalleFactura {
    private Integer id;
    private Integer cantidadProductos;
    private Integer prcUnidad;
    private Integer prcTotal;

   
    
    private int idDetalleFactura;

    // constructor

    public DetalleFactura(Integer id, Integer prcTotal, Integer prcUnidad, Integer cantidadProductos){

        this.cantidadProductos = cantidadProductos;
        this.id = id;
        this.prcUnidad = prcUnidad;
        this.prcTotal = prcTotal;

    }

    public DetalleFactura() {
    }

    // getters and setters

    public Integer getPrcUnidad() {
        return prcUnidad;
    }

    public void setPrcUnidad(Integer prcUnidad) {
        this.prcUnidad = prcUnidad;
    }

    public Integer getPrcTotal() {
        return prcTotal;
    }

    public void setPrcTotal(Integer prcTotal) {
        this.prcTotal = prcTotal;
    }

    public Integer getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public Integer getCantidadProductos() {
        return this.cantidadProductos;
    }

    public void setCantidadProductos(Integer cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }
    
}
