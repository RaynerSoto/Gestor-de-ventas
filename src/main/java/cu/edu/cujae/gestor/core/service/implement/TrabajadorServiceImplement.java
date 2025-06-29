package cu.edu.cujae.gestor.core.service.implement;

import cu.edu.cujae.gestor.config.excepcion.SearchException;
import cu.edu.cujae.gestor.core.dto.trabajadorDto.TrabajadorDto;
import cu.edu.cujae.gestor.core.model.Trabajador;
import cu.edu.cujae.gestor.core.repository.RolRepository;
import cu.edu.cujae.gestor.core.repository.SexoRepository;
import cu.edu.cujae.gestor.core.repository.TrabajadorRepository;
import cu.edu.cujae.gestor.core.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorServiceImplement implements TrabajadorService {
    private final TrabajadorRepository trabajadorRepository;
    private final SexoRepository sexoRepository;
    private final RolRepository rolRepository;

    @Autowired
    public TrabajadorServiceImplement(TrabajadorRepository trabajadorRepository, SexoRepository sexoRepository, RolRepository rolRepository) {
        this.trabajadorRepository = trabajadorRepository;
        this.sexoRepository = sexoRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public void insertarTrabajador(TrabajadorDto trabajadorDto) throws SearchException {
        if (!rolRepository.existsByNombreRolEquals(trabajadorDto.rol()))
            throw new SearchException("No se puede encontrar el rol: " + trabajadorDto.rol());
        if (!sexoRepository.existsByNombreSexoEquals(trabajadorDto.sexo()))
            throw new SearchException("No se puede encontrar el sexo: " + trabajadorDto.sexo());
        trabajadorRepository.save(new Trabajador(trabajadorDto,rolRepository.getByNombreRolEquals(trabajadorDto.rol()),sexoRepository.getSexoByNombreEquals(trabajadorDto.sexo())));
    }

    @Override
    public void modificarTrabajador(TrabajadorDto trabajadorDto, Long idTrabajador) throws SearchException {
        if (!rolRepository.existsByNombreRolEquals(trabajadorDto.rol()))
            throw new SearchException("No se puede encontrar el rol: " + trabajadorDto.rol());
        if (!sexoRepository.existsByNombreSexoEquals(trabajadorDto.sexo()))
            throw new SearchException("No se puede encontrar el sexo: " + trabajadorDto.sexo());
        trabajadorRepository.save(new Trabajador(trabajadorDto,rolRepository.getByNombreRolEquals(trabajadorDto.rol()),sexoRepository.getSexoByNombreEquals(trabajadorDto.sexo()),idTrabajador));
    }

    @Override
    public void eliminarTrabajador(Long idTrabajador) throws SearchException {
        if (trabajadorRepository.existsById(idTrabajador))
            trabajadorRepository.deleteById(idTrabajador);
        throw new SearchException("No se encontró el trabajador a eliminar");
    }

    @Override
    public List<TrabajadorDto> listarTrabajadores() {
        return trabajadorRepository.findAll().stream().map(TrabajadorDto::fromTrabajador).toList();
    }
}
