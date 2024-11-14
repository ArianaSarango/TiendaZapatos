package com.example.rest;

import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;  // Import correcto para Response
import controller.Dao.services.ProductoServices; // Import correcto para ProductoServices
import controller.Dao.services.KardexServices; // Import correcto para KardexServices

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
    
    ProductoServices pd = new ProductoServices(); 
    String aux = "";
    HashMap<String, String> mapa = new HashMap<>();
    try{
        pd.getProducto().setColor(null);
        pd.getProducto().setMarca("Nike");
        pd.getProducto().setModelo("Air Force 1");
        pd.getProducto().setPrecio(100);
        pd.getProducto().setStock(10);
        pd.getProducto().setTalla("38");
        pd.getProducto().setTipoZapato("Deportivo");
        pd.save();
        
        pd.getProducto().setColor(null);
        pd.getProducto().setMarca("Nike");
        pd.getProducto().setModelo("Air Force 1");
        pd.getProducto().setPrecio(100);
        pd.getProducto().setStock(10);
        pd.getProducto().setTalla("38");
        pd.getProducto().setTipoZapato("Deportivo");
        pd.save();

        aux = "La lista está vacia"+pd.listAll().isEmpty();
    } catch (Exception e){
        System.out.println("Error al guardar: "+e);
        // Todo 

    }
        mapa.put("msg", "Ok");
        mapa.put("data", "test "+aux);
        
        // Construir la respuesta correctamente
        return Response.ok(mapa).build();
    }
}