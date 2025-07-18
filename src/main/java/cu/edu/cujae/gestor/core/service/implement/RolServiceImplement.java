package cu.edu.cujae.gestor.core.service.implement;

import cu.edu.cujae.gestor.config.excepcion.SearchException;
import cu.edu.cujae.gestor.core.dto.rolDto.RolDto;
import cu.edu.cujae.gestor.core.model.Rol;
import cu.edu.cujae.gestor.core.repository.RolRepository;
import cu.edu.cujae.gestor.core.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImplement implements RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolServiceImplement(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public void insertarRol(RolDto rol) {
        rolRepository.save(new Rol(rol));
    }

    @Override
    public void modificarRol(RolDto rol, Long rolId) throws SearchException {
        if (rolRepository.findById(rolId).isPresent()) {
            throw new SearchException("No se encontró el rol a modificar");
        }
        rolRepository.save(new Rol(rol,rolId));
    }

    @Override
    public void eliminarRol(Long rolId) throws SearchException {
        if (rolRepository.findById(rolId).isPresent()) {
            throw new SearchException("No se encontró el rol a eliminar");
        }
        rolRepository.deleteById(rolId);

    }

    @Override
    public List<RolDto> listarRol() {
        return rolRepository.findAll().stream().map(RolDto::fromRol).toList();
    }
}
