package controller.Dao.servicies;

import models.Factura;
import controller.tda.list.LinkedList;
import controller.Dao.FacturaDao;

public class FacturaServicies {

    private FacturaDao facturaDao;

    public FacturaServicies() {
<<<<<<< HEAD
        this.facturaDao = new FacturaDao();
=======
        facturaDao = new FacturaDao();
>>>>>>> origin/Juan
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

<<<<<<< HEAD
=======
    public Factura get(Integer id) throws Exception {
        return facturaDao.get(id);
    }

>>>>>>> origin/Juan
    public Boolean save() throws Exception {
        return facturaDao.save();
    }

    public Boolean update() throws Exception {
        return facturaDao.update();
    }

<<<<<<< HEAD
    public Boolean delete(int abc) throws Exception {
        return facturaDao.delete(abc);
=======
    // public Boolean delete(int id) throws Exception {
    //     return facturaDao.delete(id);
    // }

    public Boolean delete(int id) throws Exception {
        return facturaDao.delete(id);
    }
    
    public Boolean delete(Integer id) throws Exception {
        return facturaDao.delete(id);
>>>>>>> origin/Juan
    }
}
