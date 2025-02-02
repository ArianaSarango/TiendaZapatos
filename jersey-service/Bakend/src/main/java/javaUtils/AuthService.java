package javaUtils;

import controller.Dao.servicies.UsuarioServices;
import controller.tda.list.LinkedList;
import models.Usuario;
import java.util.Optional;

public class AuthService {

    public static Optional<Usuario> authenticate(String username, String password) {
        UsuarioServices usuarioService = new UsuarioServices();
        try {
            LinkedList<Usuario> usuarios = usuarioService.ListAll();
            
            for (int i = 0; i < usuarios.getSize(); i++) {
                Usuario usuario = usuarios.get(i);
                if (usuario.getUsuario().equals(username) && usuario.getPassword().equals(password)) {
                    return Optional.of(usuario);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static String generateToken(Usuario usuario) {
        return JwtUtil.generateToken(usuario.getUsuario(), usuario.getRol());
    }
}