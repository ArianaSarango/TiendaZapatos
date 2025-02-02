package controller.Dao.servicies;

import java.util.HashMap;

import controller.Dao.PersonaDao;
import controller.tda.list.LinkedList;
import models.Factura;
import models.Persona;
import models.TipoIdentificacion;

public class PersonaServices {

    private PersonaDao obj;

    public PersonaServices() {
        obj = new PersonaDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public Boolean delete(Integer id) throws Exception {
        // Llamamos al método delete del DAO
        return obj.delete(id);
    }

    public LinkedList<Persona> ListAll() {
        return obj.getListAll();
    }

    public Persona getPersona() {
        return obj.getPersona();
    }

    public void setPersona(Persona persona) {
        obj.setPersona(persona);
    }

    public Persona get(Integer id) throws Exception {
        return obj.get(id);
    }

    public TipoIdentificacion getTipoIdentificacion(String tipo) {
        return obj.getTipoIdentificacion(tipo);
    }

    public TipoIdentificacion[] getTipos() {
        return obj.getTipos();
    }

    

    //hashmap para devolver la persona
    public HashMap buscar_identificacion_factura(String texto) {
        Persona persona = obj.buscar_identificacion(texto);
        HashMap mapa = new HashMap();
        if (persona != null) {
            try {
                mapa.put("idPersona", persona.getIdPersona());
                mapa.put("nombre", persona.getNombre());
                mapa.put("apellido", persona.getApellido());
                mapa.put("tipoIdentificacion", persona.getTipoIdentificacion());
                mapa.put("numeroIdentificacion", persona.getNumeroIdentificacion());
                mapa.put("direccion", persona.getDireccion());
                mapa.put("telefono", persona.getTelefono());
                FacturaServicies fc = new FacturaServicies();
                LinkedList<Factura> listaAux = fc.search_by_person(persona.getIdPersona());
                if (!listaAux.isEmpty()) { // Corrige la condición para verificar si la lista no está vacía
                    Factura[] listaE = listaAux.toArray();
                    HashMap[] details = new HashMap[listaE.length];
                    for (int i = 0; i < listaE.length; i++) {
                        HashMap aux = new HashMap();
                        aux.put("idFactura", listaE[i].getIdFactura());
                        aux.put("numeroFactura", listaE[i].getNumeroFactura());
                        aux.put("fechaEmision", listaE[i].getFechaEmision());
                        aux.put("subtotal", listaE[i].getSubtotal());
                        aux.put("IVA", listaE[i].getIVA());
                        aux.put("descuento", listaE[i].getDescuento());
                        aux.put("totalFactura", listaE[i].getTotalFactura());
                        aux.put("estadoPago", listaE[i].getEstadoPago());
                        details[i] = aux;
                    }
                    mapa.put("facturas", details);
                } else {
                    mapa.put("facturas", new HashMap[0]);
                }
            } catch (Exception e) {
                // Manejar excepción
                mapa.put("error", e.getMessage());
            }
        }
        return mapa;
    }

}
