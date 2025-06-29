package cu.edu.cujae.gestor.core.model;

import jakarta.persistence.*;
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
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(generator = "id_usuario_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_usuario_generator",sequenceName="id_usuario_generator",allocationSize = 1,initialValue = 1)
    @Column(name = "usuario_id", nullable = false, unique = true, updatable = false)
    @NotNull(message = "El valor del ID del usuario no puede ser nulo")
    private Long id;
    @Column(name = "password", nullable = false, unique = true)
    @Size(max = 16,message = "La cantidad de caracteres máximo es 16")
    @NotBlank(message = "El valor de la contraseña no puede ser nulo o estar vacío")
    private String password;
    @Column(name = "nombre_usuario", nullable = false, unique = true)
    @Size(max = 20,message = "La cantidad de caracteres máximo es 20")
    @NotBlank(message = "El valor del campo no puede ser nulo o estar vacío")
    private String nombre_usuario;
}
