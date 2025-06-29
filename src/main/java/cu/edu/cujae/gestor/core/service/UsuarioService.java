package cu.edu.cujae.gestor.core.service;

import cu.edu.cujae.gestor.core.dto.usuarioDto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    public void insertarUsuario(UsuarioDto usuarioDto);
    public void modificarUsuario(UsuarioDto usuarioDto, Long idUsuario);
    public void eliminarUsuario(Long idUsuario);
    public List<UsuarioDto> listarUsuarios();
}
