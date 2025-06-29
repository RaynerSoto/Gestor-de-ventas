package cu.edu.cujae.gestor.core.model;

import cu.edu.cujae.gestor.core.dto.sexoDto.SexoDto;
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
@Table(name = "sexos",schema = "public")
public class Sexo {
    @Id
    @GeneratedValue(generator = "sexo_id_generator",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sexo_id_generator",sequenceName = "sexo_id_generator",allocationSize = 1,initialValue = 1)
    @Column(name = "sexo_id", nullable = false, unique = true, updatable = false)
    @NotNull(message = "El valor del ID del sexo no puede ser nulo")
    private Long sexo_id;

    @Column(name = "nombre_sexo", length = 30,nullable = false,unique = true)
    @Size(max = 30,message = "La cantidad de caracteres máximo es 30")
    @NotBlank(message = "El valor del nombre del sexo no puede ser nulo o estar vacío")
    private String nombre;

    @OneToMany(mappedBy = "sexo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Trabajador> trabajadores;

    public Sexo(SexoDto sexoDto) {
        this.nombre = sexoDto.nombre();
    }

    public Sexo(SexoDto sexoDto, Long idSexo) {
        this.nombre = sexoDto.nombre();
        this.sexo_id = idSexo;
    }

    @PrePersist
    @PreUpdate
    public void validarSexo(){
        Validacion.validarElemento(this);
    }
}
