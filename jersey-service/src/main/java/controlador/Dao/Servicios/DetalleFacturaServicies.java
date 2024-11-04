package controlador.Dao.Servicios;

import modelo.DetalleFactura;
import controlador.tda.List.LinkedList;
import controlador.Dao.DetalleFacturaDao;

public class DetalleFacturaServicies {
    
    private DetalleFacturaDao detalleFacturaDao;

    public DetalleFacturaServicies() {
        this.detalleFacturaDao = new DetalleFacturaDao();
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFacturaDao.getDetalleFactura();
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        detalleFacturaDao.setDetalleFactura(detalleFactura);
    }

    public LinkedList<DetalleFactura> ListAll() {
        return detalleFacturaDao.getListAll();
    }

    public Boolean save() throws Exception {
        return detalleFacturaDao.save();
    }

    public Boolean update() throws Exception {
        return detalleFacturaDao.update();
    }

    public Boolean delete(int abc) throws Exception {
        return detalleFacturaDao.delete(abc);
    }
}
