package controller.Dao;

import models.Factura;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class FacturaDao extends AdapterDao<Factura>{
    private Factura factura = new Factura();
    private LinkedList<Factura> listAll;

    public FacturaDao(){
        super(Factura.class);
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
        if (listAll == null) {
            this.listAll = listAll();
        }
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

    // public Boolean delete(int id) throws Exception{
    //     this.supreme(id);
    //     this.listAll = listAll();
    //     return true;
    // }

     public Boolean delete(Integer id) throws Exception {
         LinkedList<Factura> list = getLisAll();
         Factura factura = get(id);
         if (factura != null) {
             list.remove(0);
             String info = g.toJson(list.toArray());
             saveFile(info);
             this.listAll = list;
             return true;
         } else {
             System.out.println("factura con id " + id + " no encontrado.");
             return false;
         }
     }

     public Boolean delete(int idFactura) throws Exception {
        LinkedList<Factura> facturas = listAll(); // Obtener todas las facturas
    
        // Buscar el índice de la factura con el ID dado
        int indexToRemove = -1;
        for (int i = 0; i < facturas.getSize(); i++) {
            if (facturas.get(i).getIdFactura() == idFactura) {
                indexToRemove = i;
                break;
            }
        }
    
        if (indexToRemove != -1) {
            // Si se encuentra el índice, eliminar la factura
            supreme(indexToRemove);
            return true;
        } else {
            // Si no se encuentra, lanzar una excepción
            throw new Exception("Factura con ID " + idFactura + " no encontrada");
        }
    }
    
}
