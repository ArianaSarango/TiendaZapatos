package controller.Dao.servicies;

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

    public Boolean delete(int id) throws Exception {
        return obj.delete(id);
    }
    
    public LinkedList<Producto> listAll(){
        return obj.getlistAll();

    }

    public Producto getProducto(){
        return obj.getProducto();
    }

    // public void setIdProducto( Producto producto){
    //     obj.setIdProducto(producto);
    // }

    public Producto get(Integer id) throws Exception {
        return obj.get(id);
    }

    public void setProducto(Producto producto){
        obj.setProducto(producto);
    }

    public Producto get_Producto_Codigo(String codigo) throws Exception {
        LinkedList<Producto> lista = obj.getlistAll();
        Producto producto = null;
        if (lista.isEmpty()) {
            return producto;
        } else {
            Producto[] productos = lista.toArray();
            for (int i = 0; i < productos.length; i++) {
                if (productos[i].getCodigo().equals(codigo)) {
                    producto = productos[i];
                    break;
                }
            }
            return producto;
        }
    }
}