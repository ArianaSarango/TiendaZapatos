package controller.Dao.services;
import controller.tda.list.LinkedList;
import models.Kardex;
import controller.Dao.KardexDao;

public class KardexServices {
    private KardexDao obj;
    public KardexServices(){
        obj = new KardexDao();
    }
    public Boolean save() throws Exception{
        return obj.save();
    }
    public Boolean update() throws Exception{
        return obj.update();
    }
    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id); // Llamar al método delete de KardexDao
    }
    

    public LinkedList<Kardex> listAll(){
        return obj.getlistAll();

    }

    public Kardex getKardex(){
        return obj.getKardex();
    }

    public void setIdKardex( Kardex kardex){
        obj.setIdKardex(kardex);
    }

    public Kardex get(Integer id) throws Exception {
        return obj.get(id);
    }

    public void setKardex(Kardex kardex){
        obj.setKardex(kardex);
    }
}