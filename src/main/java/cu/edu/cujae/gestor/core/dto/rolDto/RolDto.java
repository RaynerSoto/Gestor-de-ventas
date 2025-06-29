package cu.edu.cujae.gestor.core.dto.rolDto;

import cu.edu.cujae.gestor.core.model.Rol;

public record RolDto(String nombreRol, String description) {
    public static RolDto fromRol(Rol rol){
        return new RolDto(rol.getNombreRol(), rol.getDescription());
    }
}
