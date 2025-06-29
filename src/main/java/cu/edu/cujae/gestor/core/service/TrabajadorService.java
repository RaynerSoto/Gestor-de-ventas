package cu.edu.cujae.gestor.core.service;

import cu.edu.cujae.gestor.config.excepcion.SearchException;
import cu.edu.cujae.gestor.core.dto.trabajadorDto.TrabajadorDto;

import java.util.List;

public interface TrabajadorService {
    public void insertarTrabajador(TrabajadorDto trabajadorDto) throws SearchException;
    public void modificarTrabajador(TrabajadorDto trabajadorDto, Long idTrabajador) throws SearchException;
    public void eliminarTrabajador(Long idTrabajador) throws SearchException;
    public List<TrabajadorDto> listarTrabajadores();
}
