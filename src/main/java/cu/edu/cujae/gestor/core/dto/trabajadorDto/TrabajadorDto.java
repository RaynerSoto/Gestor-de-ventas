package cu.edu.cujae.gestor.core.dto.trabajadorDto;

import cu.edu.cujae.gestor.core.model.Rol;
import cu.edu.cujae.gestor.core.model.Sexo;
import cu.edu.cujae.gestor.core.model.Trabajador;

public record TrabajadorDto(String ci,
                            String nombre_completo,
                            String telefono,
                            String rol,
                            String sexo) {
    public static TrabajadorDto fromTrabajador(Trabajador trabajador){
        return new TrabajadorDto(trabajador.getCi(), trabajador.getNombre_completo(), trabajador.getTelefono(), trabajador.getRol().getNombreRol(),trabajador.getSexo().getNombre());
    }
}
