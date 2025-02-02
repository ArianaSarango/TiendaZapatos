package controller.Dao.servicies;

import controller.Dao.ProveedorDao;
import controller.tda.list.LinkedList;
import models.Proveedor;

public class ProveedorServices {
    private ProveedorDao obj;

    public ProveedorServices() {
        obj = new ProveedorDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public Boolean delete(Integer id) throws Exception {
        // Llamamos al método delete del DAO
        return obj.delete(id);
    }

    public LinkedList<Proveedor> listAll() {
        return obj.getListAll();
    }

    public Proveedor getProveedor() {
        return obj.getProveedor();
    }

    public Proveedor get(Integer id) throws Exception {
        return obj.get(id);
    }

    public void setProveedor(Proveedor proveedor) {
        obj.setProveedor(proveedor);
    }
}
