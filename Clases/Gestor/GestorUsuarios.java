
package Clases.Gestor;

import Clases.Usuario.Usuario;
import java.util.ArrayList;
import java.util.List;


public class GestorUsuarios {

    private final List<Usuario> usuarios;

 
    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorCorreo(String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean eliminarUsuario(String correo) {
        Usuario usuario = buscarUsuarioPorCorreo(correo);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

    public List<Usuario> obtenerUsuarios() {
        return new ArrayList<>(usuarios);
    }
}