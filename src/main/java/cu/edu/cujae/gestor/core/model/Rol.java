package cu.edu.cujae.gestor.core.model;

import cu.edu.cujae.gestor.core.dto.rolDto.RolDto;
import cu.edu.cujae.gestor.utils.Validacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles",schema = "public")
public class Rol {

    @Id
    @GeneratedValue(generator = "rol_secuence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rol_secuence",sequenceName = "rol_secuence",initialValue = 1,allocationSize = 1)
    @Column(name = "rol_id",nullable = false,updatable = false,unique = true)
    private Long rol_id;

    @Column(name = "nombre_rol",unique = true,nullable = false,length = 100)
    @Size(min = 1,max = 100,message = "El nombre del rol debe tener entre 1 y 100 caracteres")
    @NotBlank(message = "El nombre del rol no puede estar vacío o ser nulo")
    private String nombreRol;

    @Column(unique = true, length = 100, nullable = false)
    @Size(min = 1,max = 100,message = "La descripción del rol debe tener entre 1 y 100 caracteres")
    @NotBlank(message = "La descripción del rol no puede estar vacío o ser nulo")
    private String description;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Trabajador> trabajador;

    public Rol(RolDto rol) {
        this.nombreRol = rol.nombreRol();
        this.description = rol.description();
    }

    public Rol(RolDto rol, Long rolId) {
        this.rol_id = rolId;
        this.nombreRol = rol.nombreRol();
        this.description = rol.description();
    }

    @PrePersist
    @PreUpdate
    public void validarRol(){
        Validacion.validarElemento(this);
    }
}
