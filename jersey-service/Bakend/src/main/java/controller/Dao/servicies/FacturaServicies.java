package controller.Dao.servicies;

import models.Factura;
import controller.tda.list.LinkedList;
import controller.Dao.FacturaDao;

public class FacturaServicies {

    private FacturaDao facturaDao;

    public FacturaServicies() {
        this.facturaDao = new FacturaDao();
    }

    public Factura getFactura() {
        return facturaDao.getFactura();
    }

    public void setFactura(Factura factura) {
        facturaDao.setFactura(factura);
    }

    public LinkedList<Factura> ListAll() {
        return facturaDao.getLisAll();
    }

    public Boolean save() throws Exception {
        return facturaDao.save();
    }

    public Boolean update() throws Exception {
        return facturaDao.update();
    }

    public Boolean delete(int abc) throws Exception {
        return facturaDao.delete(abc);
    }
}
