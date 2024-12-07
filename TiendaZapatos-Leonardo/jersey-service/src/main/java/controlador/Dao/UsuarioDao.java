package controlador.Dao;

import modelo.Usuario;
import modelo.Persona;
import java.util.List;
import controlador.Dao.Implementacion.AdapterDao;
import controlador.tda.List.LinkedList;

public class UsuarioDao extends AdapterDao<Usuario>{
    private Usuario usuario;
    private LinkedList listAll;

    public UsuarioDao() {
        super(Usuario.class);
    }
    
    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LinkedList getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception{
        Integer id = getListAll().getSize() + 1;
        usuario.setIdUser(id);
        this.persist(this.usuario);
        this.listAll = getListAll();
        return true;
    }

    public Boolean update() throws Exception{
        this.merge(getUsuario(), getUsuario().getIdUser()-1);
        this.listAll = getListAll();
        return true;
    }

    public Boolean delete(int abc) throws Exception{
        this.delete(abc);
        this.listAll = getListAll();
        return true;
    }
}