package controller.Dao;

import models.Usuario;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class UsuarioDao extends AdapterDao<Usuario> {
    private Usuario usuario;
    private LinkedList<Usuario> listAll;

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

    public LinkedList<Usuario> getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        // 1. Obtener el nuevo ID correctamente
        int newId = getListAll().getSize() + 1;
        
        // 2. Configurar el ID y rol por defecto
        usuario.setIdUsuario(newId);
        
        if (usuario.getRol() == null) {
            usuario.setRol("cliente");
        }
        
        // 3. Persistir el usuario
        this.persist(usuario);
        
        // 4. Actualizar la lista cacheada
        this.listAll = listAll();  // Forzar recarga de datos
        
        return true;
    }

    public Boolean update() throws Exception {
        // Verificar que el usuario exista en la lista
        if (usuario.getIdUsuario() > 0 && usuario.getIdUsuario() <= getListAll().getSize()) {
            this.merge(usuario, usuario.getIdUsuario() - 1);
            this.listAll = listAll();  // Actualizar lista
            return true;
        }
        return false;
    }

    public Boolean delete(int index) throws Exception {
        // Validar índice
        if (index >= 0 && index < getListAll().getSize()) {
            this.delete(index);
            this.listAll = listAll();  // Actualizar lista
            return true;
        }
        return false;
    }
}