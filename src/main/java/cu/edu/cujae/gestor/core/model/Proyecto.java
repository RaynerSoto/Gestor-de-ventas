package cu.edu.cujae.gestor.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long id;
    @Column(name = "titulo", length = 60, nullable = false, unique = true)
    @NotBlank(message = "El titulo no puede ser nulo o estar vacio.")
    private String titulo;
    @Column(name = "descripcion", length = 100, nullable = false, unique = true)
    @NotBlank(message = "La descripcion no puede ser nula o estar vacia.")
    private String descripcion;
}
