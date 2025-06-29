package cu.edu.cujae.gestor.core.service.implement;

import cu.edu.cujae.gestor.config.excepcion.SearchException;
import cu.edu.cujae.gestor.core.dto.proyectoDto.ProyectoDto;
import cu.edu.cujae.gestor.core.model.Proyecto;
import cu.edu.cujae.gestor.core.repository.ProyectoRepository;
import cu.edu.cujae.gestor.core.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServiceImplement implements ProyectoService {
    private final ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoServiceImplement(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }
    @Override
    public void insertarProyecto(ProyectoDto proyectoDto) {
        proyectoRepository.save(new Proyecto(proyectoDto));
    }

    @Override
    public void modificarProyecto(ProyectoDto proyectoDto, Long idProyecto) throws SearchException {
        if (!proyectoRepository.existsById(idProyecto)) {
            throw new SearchException("No se encontró el proyecto a modificar");
        }
        proyectoRepository.save(new Proyecto(proyectoDto, idProyecto));
    }

    @Override
    public void eliminarProyecto(Long idProyecto) throws SearchException {
        if (!proyectoRepository.existsById(idProyecto)) {
            throw new SearchException("No se encontró el proyecto a eliminar");
        }
        proyectoRepository.deleteById(idProyecto);
    }

    @Override
    public List<ProyectoDto> listarProyectos() {
        return proyectoRepository.findAll().stream()
                .map(ProyectoDto::fromProyecto)
                .toList();
    }
}
