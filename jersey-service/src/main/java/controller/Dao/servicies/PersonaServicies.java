package controller.Dao.servicies;
import controller.tda.list.LinkedList;
import models.Persona;
import controller.Dao.PersonaDao;

public class PersonaServicies {
    private PersonaDao obj;
    public PersonaServicies(){
        obj = new PersonaDao();
    }
    public Boolean save() throws Exception{
        return obj.save();
    }
    public Boolean update() throws Exception{
        return obj.update();
    }
    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id); // Llamar al método delete de PersonaDao
    }
    

    public LinkedList listAll(){
        return obj.getlistAll();

    }

    public Persona getPersona(){
        return obj.getPersona();
    }

    public void setPersona( Persona persona){
        obj.setPersona(persona);
    }

    public Persona get(Integer id) throws Exception {
        return obj.get(id);
    }

  
}
