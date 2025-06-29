package cu.edu.cujae.gestor.core.model;

import cu.edu.cujae.gestor.utils.Validacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios",schema = "public")
public class Usuario {

    @Id
    @GeneratedValue(generator = "id_usuario_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_usuario_generator",sequenceName="id_usuario_generator",allocationSize = 1,initialValue = 1)
    @Column(name = "usuario_id", nullable = false, unique = true, updatable = false)
    @NotNull(message = "El valor del ID del usuario no puede ser nulo")
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true,length = 150)
    @Size(max = 150, message = "La cantidad de caracteres máximo es 150")
    @NotBlank(message = "El valor del nombre no puede ser nulo o estar vacío")
    private String nombre;

    @Column(name = "password", nullable = false, unique = true,length = 255)
    @Size(max = 255,message = "La cantidad de caracteres máximo es 255")
    @NotBlank(message = "El valor de la contraseña no puede ser nulo o estar vacío")
    private String password;

    @Column(name = "nombre_usuario", nullable = false, unique = true,length = 50)
    @Size(max = 50,message = "La cantidad de caracteres máximo es 50")
    @NotBlank(message = "El valor del campo no puede ser nulo o estar vacío")
    private String nombre_usuario;

    @Column(name = "email", nullable = false, unique = true,length = 200)
    @Size(max = 200, message = "La cantidad de caracteres máximo es 200")
    @Email(message = "El email debe ser válido")
    @NotBlank(message = "El valor del email no puede ser nulo o estar vacío")
    private String email;

    @PrePersist
    @PreUpdate
    private void validarUsuario(){
        Validacion.validarElemento(this);
    }
}
