package controller.Dao;

import models.Persona;
import models.TipoIdentificacion;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class PersonaDao extends AdapterDao<Persona>{
    private Persona persona;
    private LinkedList<Persona> listAll;

    public PersonaDao() {
        super(Persona.class);
    }
    

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception{
        Integer id = getListAll().getSize() + 1;
        persona.setIdPersona(id);
        this.persist(this.persona);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {
        // Obtener la persona desde la base de datos (usando el ID)
        Persona persona = getPersona();
        
        // Verificar si la persona existe antes de actualizarla
        if (persona == null) {
            throw new Exception("Persona no encontrada");
        }
        
        // Actualizar los datos de la persona
        this.merge(persona, persona.getIdPersona() - 1);
        
        // Actualizar la lista después de la actualización
        this.listAll = listAll();
        
        return true;
    }
    

    public Boolean delete(int id) throws Exception {
        LinkedList<Persona> lista = getListAll();
        
        // Buscar el índice de la persona a eliminar
        int indexToRemove = -1;
        for (int i = 0; i < lista.getSize(); i++) {
            if (lista.get(i).getIdPersona() == id) {
                indexToRemove = i;
                break;
            }
        }
    
        if (indexToRemove == -1) {
            throw new Exception("Persona con id " + id + " no encontrada.");
        }
    
        // Eliminar la persona por su índice
        lista.remove(indexToRemove);
        
        // Actualizar la lista después de la eliminación
        this.listAll = lista;
        
        return true;
    }
    
    
    

    public TipoIdentificacion getTipoIdentificacion(String tipo) {
        return TipoIdentificacion.valueOf(tipo);
    }

    public TipoIdentificacion[] getTipos() {
        return TipoIdentificacion.values();
    }

    //metodo de busqueda
    public Persona buscar_identificacion(String texto){
        Persona persona = null;
        LinkedList<Persona> lista = getListAll();
        if (lista.isEmpty()) {
            Persona[] aux = lista.toArray();
            for (int i = 0; i < aux.length; i++) {
                if (aux[i].getTipoIdentificacion().equals(texto)) {
                    persona = aux[i];
                    break;
                }
            }
        }
        return persona;
    }


}
