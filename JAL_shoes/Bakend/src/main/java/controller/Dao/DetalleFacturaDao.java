package controller.Dao;

import models.DetalleFactura;
import models.Factura;
import java.util.List;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class DetalleFacturaDao extends AdapterDao<DetalleFactura>{
    private DetalleFactura detalleFactura = new DetalleFactura();
    private LinkedList<DetalleFactura> listAll;

    public DetalleFacturaDao() {
        super(DetalleFactura.class);
        this.listAll = new LinkedList<>();
    }
    
    public DetalleFactura getDetalleFactura() {
        if (detalleFactura == null) {
            detalleFactura = new DetalleFactura();
        }
        return this.detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public LinkedList<DetalleFactura> getListAll() {
        return listAll;
    }

    public Boolean save() throws Exception{
        Integer id = getListAll().getSize() + 1;
        detalleFactura.setIdDetalleFactura(id);
        this.persist(this.detalleFactura);
        this.listAll = getListAll();
        return true;
    }

    public Boolean update() throws Exception{
        this.merge(getDetalleFactura(), getDetalleFactura().getId()-1);
        this.listAll = getListAll();
        return true;
    }

    public Boolean delete(int abc) throws Exception{
        this.delete(abc);
        this.listAll = getListAll();
        return true;
    }
}