package cu.edu.cujae.gestor.core.service.implement;

import cu.edu.cujae.gestor.core.dto.usuarioDto.UsuarioDto;
import cu.edu.cujae.gestor.core.model.Usuario;
import cu.edu.cujae.gestor.core.repository.UsuarioRepository;
import cu.edu.cujae.gestor.core.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImplement(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void insertarUsuario(UsuarioDto usuarioDto) {
        usuarioRepository.save(new Usuario(usuarioDto));
    }

    @Override
    public void modificarUsuario(UsuarioDto usuarioDto, Long idUsuario) {

    }

    @Override
    public void eliminarUsuario(Long idUsuario) {

    }

    @Override
    public List<UsuarioDto> listarUsuarios() {
        return List.of();
    }
}
