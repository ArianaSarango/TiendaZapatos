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
        try {
            this.merge(getPersona(), getPersona().getIdPersona() - 1);
            this.listAll = getListAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public Boolean delete(Integer idPersona) throws Exception {
        LinkedList<Persona> personas = getListAll();  // Obtener todas las personas
        
        // Buscar el índice de la persona con el ID proporcionado
        int indexToRemove = -1;
        for (int i = 0; i < personas.getSize(); i++) {
            if (personas.get(i).getIdPersona() == idPersona) {
                indexToRemove = i;  // Encontramos la persona, guardamos su índice
                break;
            }
        }
    
        if (indexToRemove != -1) {
            // Si encontramos la persona, eliminarla por su índice
            personas.remove(indexToRemove);
            
            // Convertir la lista actualizada a JSON (si es necesario)
            String info = g.toJson(personas.toArray());
        
            // Guardar el archivo actualizado
            saveFile(info);
        
            // Actualizar la lista en memoria
            this.listAll = personas;
        
            return true;  // Persona eliminada con éxito
        } else {
            // Si la persona no se encuentra, lanzar una excepción
            throw new Exception("Persona con ID " + idPersona + " no encontrada");
        }
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
