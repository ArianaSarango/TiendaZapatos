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
    public Boolean deleteFactura(int idFactura) throws Exception {
        LinkedList<Factura> facturas = listAll(); // Obtén la lista de facturas
        Factura facturaToRemove = null;
    
        // Buscar la factura con el ID dado
        for (Factura factura : facturas) {
            if (factura.getIdFactura() == idFactura) {
                facturaToRemove = factura;
                break;
            }
        }
    
        if (facturaToRemove != null) {
            facturas.remove(facturaToRemove); // Elimina la factura encontrada
            String info = g.toJson(facturas.toArray()); // Convierte la lista actualizada a JSON
            saveFile(info); // Guarda la lista actualizada en el archivo JSON
            return true;
        } else {
            throw new Exception("Factura con ID " + idFactura + " no encontrada");
        }
    }
    
}
