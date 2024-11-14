package controller.Dao;

import models.Proveedor;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class ProveedorDao extends AdapterDao<Proveedor> {
    private Proveedor proveedor;
    private LinkedList<Proveedor> listAll;

    public ProveedorDao() {
        super(Proveedor.class);
        this.listAll = new LinkedList<>();
    }

    public void setIdProveedor(Proveedor proveedor) {
        int id = 1;
        for (Proveedor p : getListAll()) {
            if (p.getId() >= id) {
                id = p.getId() + 1; 
            }
        }
        proveedor.setId(id);  
    }

    public Proveedor getProveedor() {
        if (proveedor == null) {
            proveedor = new Proveedor();
        }
        return this.proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LinkedList<Proveedor> getListAll() {
        if (listAll.isEmpty()) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        proveedor.setId(id);
        this.persist(this.proveedor);
        this.listAll = getListAll();
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getProveedor(), getProveedor().getId() - 1);
            this.listAll = getListAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Proveedor> list = getListAll();
        Proveedor proveedor = get(id);
        if (proveedor != null) {
            list.remove(proveedor);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Proveedor con id " + id + " no encontrado.");
            return false;
        }
    }
}
