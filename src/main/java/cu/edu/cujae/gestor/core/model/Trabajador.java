package cu.edu.cujae.gestor.core.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "trabajadores")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 11, nullable = false)
    private String ci;
    @Column(unique = true, length = 50, nullable = false)
    private String nombre_completo;
    @Column(unique = true, length = 8, nullable = false)
    private String telefono;
    @ManyToOne(optional = false)
    private Rol roles;
    //Relación de Muchos a Uno con Sexo
}
