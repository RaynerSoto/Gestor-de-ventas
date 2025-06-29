package cu.edu.cujae.gestor.core.dto.proyectoDto;

import cu.edu.cujae.gestor.core.model.Proyecto;

public record ProyectoDto(String titulo, String descripcion) {
    public static ProyectoDto fromProyecto(Proyecto proyecto) {
        return new ProyectoDto(proyecto.getTitulo(), proyecto.getDescripcion());
    }
}
