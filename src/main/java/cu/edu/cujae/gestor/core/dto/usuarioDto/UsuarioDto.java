package cu.edu.cujae.gestor.core.dto.usuarioDto;

import cu.edu.cujae.gestor.core.model.Usuario;

public record UsuarioDto(String nombre,
                         String password,
                         String nombre_usuario,
                         String email) {
    public static UsuarioDto fromUsuario(Usuario usuario) {
        return new UsuarioDto(
                usuario.getNombre(),
                usuario.getPassword(),
                usuario.getNombre_usuario(),
                usuario.getEmail()
        );
    }
}
