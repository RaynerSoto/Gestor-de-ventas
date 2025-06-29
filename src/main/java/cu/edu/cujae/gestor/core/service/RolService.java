package cu.edu.cujae.gestor.core.service;

import cu.edu.cujae.gestor.config.excepcion.SearchException;
import cu.edu.cujae.gestor.core.dto.rolDto.RolDto;

import java.util.List;

public interface RolService {
    public void insertarRol(RolDto rol);
    public void modificarRol(RolDto rol,Long rolId) throws SearchException;
    public void eliminarRol(Long rolId) throws SearchException;
    public List<RolDto> listarRol();
}
