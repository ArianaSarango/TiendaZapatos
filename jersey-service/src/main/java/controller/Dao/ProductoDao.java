package controller.Dao;

import models.Producto;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class ProductoDao extends AdapterDao<Producto> {
    private Producto producto; 
    private LinkedList<Producto> listAll;
    
    public void setIdProducto(Producto producto) {

    }

    public ProductoDao(){
        super(Producto.class);
        this.listAll = new LinkedList<>();
    }

    public Producto getProducto() {
        if (producto == null) {
            producto = new Producto();
        }
        return this.producto;
    }

    public void setProducto(Producto producto){
        this.producto = producto;
    }

    public LinkedList<Producto> getlistAll(){
        if (listAll.isEmpty()) { 
            this.listAll = listAll(); 
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;
        producto.setIdProducto(id);
        this.persist(this.producto);
        this.listAll = getlistAll(); 
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getProducto(), getProducto().getIdProducto() - 1);
            this.listAll = getlistAll(); 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Producto> list = getlistAll(); 
        Producto producto = get(id); 
        if (producto != null) {
            list.remove(producto); 
            String info = g.toJson(list.toArray());
            saveFile(info); 
            this.listAll = list;
            return true;
        } else {
            System.out.println("Producto con id " + id + " no encontrada.");
            return false;
        }
    }
}