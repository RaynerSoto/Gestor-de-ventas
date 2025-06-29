package cu.edu.cujae.gestor.core.model;

import cu.edu.cujae.gestor.utils.Validacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trabajadores",schema = "public")
public class Trabajador {

    @Id
    @GeneratedValue(generator = "trabajador_id_generator",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "trabajador_id_generator",sequenceName = "trabajador_id_generator",allocationSize = 1,initialValue = 1)
    @Column(name = "trabajador_id", nullable = false, unique = true, updatable = false)
    private Long trabajador_id;

    @Column(unique = true, length = 11, nullable = false)
    @NotBlank(message = "El CI no puede estar vacío o ser nulo")
    @Size(min = 11, max = 11,message = "El CI debe tener exactamente 11 caracteres")
    private String ci;

    @NotBlank(message = "El nombre completo no puede estar vacío o ser nulo")
    @Column(length = 100, nullable = false)
    @Size(max = 100, message = "El nombre completo no puede tener más de 100 caracteres")
    private String nombre_completo;

    @NotBlank(message = "El nombre de usuario no puede estar vacío o ser nulo")
    @Column(unique = true, length = 8, nullable = false)
    @Size(min = 8, max = 8, message = "El teléfono debe tener exactamente 8 caracteres")
    private String telefono;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sexo_id", nullable = false)
    private Sexo sexo;

    @PrePersist
    @PreUpdate
    public void prePersistUpdate() {
        Validacion.validarElemento(this);
    }
}
