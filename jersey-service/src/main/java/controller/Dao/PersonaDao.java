package controller.Dao;

import models.Persona;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class PersonaDao extends AdapterDao<Persona> {
    private Persona persona; 
    private LinkedList<Persona> listAll;
    
    public PersonaDao(){
        super(Persona.class);
        this.listAll = new LinkedList<>();
    }

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return this.persona;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
    }

    public LinkedList<Persona> getlistAll(){
        if (listAll.isEmpty()) { 
            this.listAll = listAll(); 
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;
        persona.setIdPersona(id);
        this.persist(this.persona);
        this.listAll = getlistAll(); 
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getPersona(), getPersona().getIdPersona() - 1);
            this.listAll = getlistAll(); 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Persona> list = getlistAll(); 
        Persona persona = get(id); 
        if (persona != null) {
            list.remove(persona); 
            String info = g.toJson(list.toArray());
            saveFile(info); 
            this.listAll = list;
            return true;
        } else {
            System.out.println("Persona con id " + id + " no encontrada.");
            return false;
        }
    }
}
