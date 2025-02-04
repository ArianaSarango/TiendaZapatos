package controller.Dao;

import models.Producto;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;
import controller.tda.list.ListEmptyException;

public class ProductoDao extends AdapterDao<Producto> {
    private Producto producto = new Producto();
    private LinkedList<Producto> listAll;

    public void setIdProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoDao() {
        super(Producto.class);
        this.listAll = new LinkedList<>();
    }

    public Producto getProducto() {
        if (producto == null) {
            producto = new Producto();
        }
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LinkedList<Producto> getlistAll() {
        if (listAll == null || listAll.isEmpty()) {
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

    public Boolean delete(int idProducto) throws Exception {
        LinkedList<Producto> productos = listAll(); // Obtener todas las productos

        // Buscar el índice de la producto con el ID dado
        int indexToRemove = -1;
        for (int i = 0; i < productos.getSize(); i++) {
            if (productos.get(i).getIdProducto() == idProducto) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            // Si se encuentra el índice, eliminar la producto
            supreme(indexToRemove);
            return true;
        } else {
            // Si no se encuentra, lanzar una excepción
            throw new Exception("Producto con ID " + idProducto + " no encontrada");
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Producto> list = getlistAll();
        Producto producto = get(id);
        if (producto != null) {
            list.remove(0);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Producto con id " + id + " no encontrada.");
            return false;
        }
    }

    public Producto get(Integer id) throws IndexOutOfBoundsException, ListEmptyException {
        System.out.println("Lista de productos disponibles:");
        for (int i = 0; i < getlistAll().getSize(); i++) {
            System.out.println("ID=" + getlistAll().get(i).getIdProducto() +
                    ", Código=" + getlistAll().get(i).getCodigo());
            if (getlistAll().get(i).getIdProducto() == id) {
                return getlistAll().get(i);
            }
        }
        return null;
    }

}