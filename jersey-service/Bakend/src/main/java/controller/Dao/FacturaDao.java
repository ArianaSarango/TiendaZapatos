package controller.Dao;

import models.Factura;
import java.util.List;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class FacturaDao extends AdapterDao<Factura>{
    private Factura factura = new Factura();
    private LinkedList<Factura> listAll;

    public FacturaDao() {
        super(Factura.class);
        this.listAll = new LinkedList<>();
    }
    
    public Factura getFactura() {
        if (factura == null) {
            factura = new Factura();
        }
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public LinkedList<Factura> getLisAll() {
        return listAll;
    }

    public Boolean save() throws Exception{
        Integer id = getLisAll().getSize() + 1;
        factura.setIdFactura(id);
        this.persist(this.factura);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception{
        this.merge(getFactura(), getFactura().getIdFactura()-1);
        this.listAll = listAll();
        return true;
    }

    public Boolean delete(int abc) throws Exception{
        this.delete(abc);
        this.listAll = listAll();
        return true;
    }
}
