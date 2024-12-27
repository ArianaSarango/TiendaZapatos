package controller.Dao;

import models.Proveedor;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class ProveedorDao extends AdapterDao<Proveedor> {
    private Proveedor proveedor = new Proveedor();
    private LinkedList<Proveedor> listAll;

    public ProveedorDao() {
        super(Proveedor.class);
        this.listAll = new LinkedList<>();
    }

    // public void setIdProveedor(Proveedor proveedor) {
    //     int id = 1;
    //     for (Proveedor p : getListAll()) {
    //         if (p.getId() >= id) {
    //             id = p.getId() + 1; 
    //         }
    //     }
    //     proveedor.setId(id);  
    // }

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

    public Boolean delete(Integer idProveedor) throws Exception {
        LinkedList<Proveedor> proveedores = getListAll();  // Obtener todos los proveedores
    
        // Buscar el índice del proveedor con el ID proporcionado
        int indexToRemove = -1;
        for (int i = 0; i < proveedores.getSize(); i++) {
            if (proveedores.get(i).getId() == idProveedor) {
                indexToRemove = i;  // Encontramos el proveedor, guardamos su índice
                break;
            }
        }
    
        if (indexToRemove != -1) {
            // Si encontramos el proveedor, eliminarlo por su índice
            proveedores.remove(indexToRemove);
            
            // Convertir la lista actualizada a JSON (si es necesario)
            String info = g.toJson(proveedores.toArray());
    
            // Guardar el archivo actualizado
            saveFile(info);
    
            // Actualizar la lista en memoria
            this.listAll = proveedores;
    
            return true;  // Proveedor eliminado con éxito
        } else {
            // Si el proveedor no se encuentra, lanzar una excepción
            throw new Exception("Proveedor con ID " + idProveedor + " no encontrado");
        }
    }
    
    
    
    // public Boolean delete(Integer id) throws Exception {
    //     LinkedList<Proveedor> list = getListAll();
    //     Proveedor proveedor = get(id);
    //     if (proveedor != null) {
    //         list.remove(proveedor);
    //         String info = g.toJson(list.toArray());
    //         saveFile(info);
    //         this.listAll = list;
    //         return true;
    //     } else {
    //         System.out.println("Proveedor con id " + id + " no encontrado.");
    //         return false;
    //     }
    // }
}
