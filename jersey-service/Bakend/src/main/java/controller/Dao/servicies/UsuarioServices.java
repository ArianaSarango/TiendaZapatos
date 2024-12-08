package controller.Dao.servicies;

import controller.Dao.UsuarioDao; 
import controller.tda.list.LinkedList;
import models.Usuario;

public class UsuarioServices {
    
    private UsuarioDao obj;

    public UsuarioServices() {
        obj = new UsuarioDao();
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

    public LinkedList<Usuario> ListAll() {
        return obj.getListAll();
    }

    public Usuario getUsuario() {
        return obj.getUsuario();
    }

    public Usuario get(Integer id) throws Exception {
        return obj.get(id);
    }

    public void setUsuario(Usuario usuario){ 
        obj.setUsuario(usuario);
    }
}