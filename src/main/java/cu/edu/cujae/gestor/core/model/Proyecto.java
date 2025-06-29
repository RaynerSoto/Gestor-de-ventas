package cu.edu.cujae.gestor.core.model;

import cu.edu.cujae.gestor.core.dto.proyectoDto.ProyectoDto;
import cu.edu.cujae.gestor.utils.Validacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(generator = "proyecto_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "proyecto_id", sequenceName = "proyecto_id", allocationSize = 1, initialValue = 1)
    @NotNull(message = "El valor del ID de la descripcion no puede ser nulo.")
    @Column(name = "proyecto_id", nullable = false, unique = true, updatable = false)
    private Long proyecto_id;

    @Column(name = "titulo", length = 60, nullable = false, unique = true)
    @NotBlank(message = "El titulo no puede ser nulo o estar vacio.")
    @Size(max = 60, message = "El titulo no puede tener mas de 60 caracteres.")
    private String titulo;

    @Column(name = "descripcion", length = 100, nullable = false, unique = true)
    @NotBlank(message = "La descripcion no puede ser nula o estar vacia.")
    @Size(max = 100, message = "La descripcion no puede tener mas de 100 caracteres.")
    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "proyecto_trabajador",
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "trabajador_id"))
    private List<Trabajador> trabajadores;

    public Proyecto(ProyectoDto proyectoDto) {
        this.descripcion = proyectoDto.descripcion();
        this.titulo = proyectoDto.titulo();
    }

    public Proyecto(ProyectoDto proyectoDto, Long idProyecto) {
        this.proyecto_id = idProyecto;
        this.descripcion = proyectoDto.descripcion();
        this.titulo = proyectoDto.titulo();
    }

    @PrePersist
    @PreUpdate
    public void validarProyecto(){
        Validacion.validarElemento(this);
    }
}
