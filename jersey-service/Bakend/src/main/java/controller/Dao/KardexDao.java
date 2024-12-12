package controller.Dao;

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

    public Boolean delete(int abc) throws Exception{
        this.delete(abc);
        this.listAll = listAll();
        return true;
    }

    // public Boolean delete(Integer id) throws Exception {
    //     LinkedList<Kardex> list = getlistAll(); 
    //     Kardex kardex = get(id); 
    //     if (kardex != null) {
    //         list.remove(kardex);
    //         String info = g.toJson(list.toArray());
    //         saveFile(info); 
    //         this.listAll = list;
    //         return true;
    //     } else {
    //         System.out.println("Kardex con id " + id + " no encontrada.");
    //         return false;
    //     }
    // }

}
