package cu.edu.cujae.gestor.core.service;

import cu.edu.cujae.gestor.config.excepcion.SearchException;
import cu.edu.cujae.gestor.core.dto.sexoDto.SexoDto;

import java.util.List;

public interface SexoService {
    public void insertarSexo(SexoDto sexoDto);
    public void modificarSexo(SexoDto sexoDto,Long idSexo) throws SearchException;
    public void eliminarSexo(Long idSexo) throws SearchException;
    public List<String> listarSexo();
}
