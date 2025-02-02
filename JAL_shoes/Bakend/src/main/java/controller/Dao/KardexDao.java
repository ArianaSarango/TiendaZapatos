package controller.Dao;

import models.Kardex;
import models.Kardex;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;
;
public class KardexDao extends AdapterDao<Kardex> {
    private Kardex kardex = new Kardex();
    private LinkedList<Kardex> listAll;
    
    public KardexDao(){
        super(Kardex.class);
        this.listAll = new LinkedList<>();
    }

    // public void setIdKardex(Kardex kardex) {

    // }
    
    public Kardex getKardex() {
        if (kardex == null) {
            kardex = new Kardex();
        }
        return this.kardex;
    }

    public void setKardex(Kardex kardex){
        this.kardex = kardex;
    }

    public LinkedList<Kardex> getlistAll(){
        if (listAll.isEmpty()) { 
            this.listAll = listAll(); 
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;
        kardex.setIdKardex(id);
        this.persist(this.kardex);
        this.listAll = getlistAll(); 
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getKardex(), getKardex().getIdKardex() - 1);
            this.listAll = getlistAll(); 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(int idKardex) throws Exception {
        LinkedList<Kardex> kardexs = listAll(); // Obtener todas las kardexs
    
        // Buscar el índice de la kardex con el ID dado
        int indexToRemove = -1;
        for (int i = 0; i < kardexs.getSize(); i++) {
            if (kardexs.get(i).getIdKardex() == idKardex) {
                indexToRemove = i;
                break;
            }
        }
    
        if (indexToRemove != -1) {
            // Si se encuentra el índice, eliminar la kardex
            supreme(indexToRemove);
            return true;
        } else {
            // Si no se encuentra, lanzar una excepción
            throw new Exception("Kardex con ID " + idKardex + " no encontrada");
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Kardex> list = getlistAll(); 
        Kardex kardex = get(id); 
        if (kardex != null) {
            list.remove(0);
            String info = g.toJson(list.toArray());
            saveFile(info); 
            this.listAll = list;
            return true;
        } else {
            System.out.println("Kardex con id " + id + " no encontrada.");
            return false;
        }
    }

}
