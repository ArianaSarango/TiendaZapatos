package com.Practica.rest;

import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controlador.Dao.Servicios.FacturaServicies;
import controlador.Dao.Servicios.DetalleFacturaServicies;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as JSON media type.
     *
     * @return Response that will be returned to the client.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        HashMap<String, Object> mapa = new HashMap<>();
        FacturaServicies fs = new FacturaServicies();
        DetalleFacturaServicies dfs = new DetalleFacturaServicies();
        String aux = "";
        try {
            
            fs.getFactura().setNumeroFactura(0);
            fs.getFactura().setSubtotal(0.0);
            fs.getFactura().setIVA(0);
            fs.getFactura().setDescuento(0);
            fs.getFactura().setTotalFactura(0.0);
            fs.getFactura().setEstadoPago(null);
            fs.save();

            dfs.getDetalleFactura().setIdDetalleFactura(0);
            dfs.getDetalleFactura().setIdProducto(0);
            dfs.getDetalleFactura().setPrecioProducto(50.0);
            dfs.getDetalleFactura().setCantidadProductos(0);
            dfs.save();
        

            aux = "La lista está vacía: " + fs.ListAll()+ dfs.ListAll().isEmpty();
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e);

        }
        mapa.put("msg", "Ok");
        mapa.put("data", "test " + aux);
        

        return Response.ok(mapa).build();
    }

}
