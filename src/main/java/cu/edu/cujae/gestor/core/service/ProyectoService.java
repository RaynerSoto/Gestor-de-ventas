package cu.edu.cujae.gestor.core.service;

import cu.edu.cujae.gestor.config.excepcion.SearchException;
import cu.edu.cujae.gestor.core.dto.proyectoDto.ProyectoDto;

import java.util.List;

public interface ProyectoService {
    public void insertarProyecto(ProyectoDto proyectoDto);
    public void modificarProyecto(ProyectoDto proyectoDto, Long idProyecto) throws SearchException;
    public void eliminarProyecto(Long idProyecto) throws SearchException;
    public List<ProyectoDto> listarProyectos();
}
