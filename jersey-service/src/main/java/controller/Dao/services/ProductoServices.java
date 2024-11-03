package controller.Dao.services;
import controller.tda.list.LinkedList;
import models.Producto;
import controller.Dao.ProductoDao;

public class ProductoServices {
    private ProductoDao obj;
    public ProductoServices(){
        obj = new ProductoDao();
    }
    public Boolean save() throws Exception{
        return obj.save();
    }
    public Boolean update() throws Exception{
        return obj.update();
    }
    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id); // Llamar al método delete de ProductoDao
    }
    
    public LinkedList<Producto> listAll(){
        return obj.getlistAll();

    }

    public Producto getProducto(){
        return obj.getProducto();
    }

    public void setIdProducto( Producto producto){
        obj.setIdProducto(producto);
    }

    public Producto get(Integer id) throws Exception {
        return obj.get(id);
    }

    public void setProducto(Producto producto){
        obj.setProducto(producto);
    }
}