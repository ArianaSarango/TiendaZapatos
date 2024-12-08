package controller.Dao.servicies;

import controller.Dao.PersonaDao;
import controller.Dao.ProveedorDao;
import controller.tda.list.LinkedList;
import models.Persona;
import models.Proveedor;
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

    public Boolean delete(int id) throws Exception {
        return obj.delete(id);
    }

    public LinkedList ListAll() {
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


}
