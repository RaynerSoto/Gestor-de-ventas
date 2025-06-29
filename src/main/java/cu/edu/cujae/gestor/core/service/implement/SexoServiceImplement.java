package cu.edu.cujae.gestor.core.service.implement;

import cu.edu.cujae.gestor.config.excepcion.SearchException;
import cu.edu.cujae.gestor.core.dto.sexoDto.SexoDto;
import cu.edu.cujae.gestor.core.model.Sexo;
import cu.edu.cujae.gestor.core.repository.SexoRepository;
import cu.edu.cujae.gestor.core.service.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexoServiceImplement implements SexoService {
    private final SexoRepository sexoRepository;

    @Autowired
    public SexoServiceImplement(SexoRepository sexoRepository) {
        this.sexoRepository = sexoRepository;
    }

    @Override
    public void insertarSexo(SexoDto sexoDto) {
        sexoRepository.save(new Sexo(sexoDto));
    }

    @Override
    public void modificarSexo(SexoDto sexoDto, Long idSexo) throws SearchException {
        if (!sexoRepository.findById(idSexo).isPresent()) {
            throw new SearchException("No se encontró el sexo a modificar");
        }
        sexoRepository.save(new Sexo(sexoDto,idSexo));
    }

    @Override
    public void eliminarSexo(Long idSexo) throws SearchException {
        if (sexoRepository.findById(idSexo).isPresent()) {
            throw new SearchException("No se encontró el sexo a eliminar");
        }
        sexoRepository.deleteById(idSexo);

    }

    @Override
    public List<String> listarSexo() {
        return sexoRepository.findAll().stream().map(Sexo::getNombre).toList();
    }
}
