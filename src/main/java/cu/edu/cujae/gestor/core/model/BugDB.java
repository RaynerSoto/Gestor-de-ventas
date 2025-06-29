package cu.edu.cujae.gestor.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bug")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BugDB {
    @Id
    @Column(unique = true, length = 5, nullable = false,updatable = false)
    private String bug_id;
    @Column(unique = true)
    private String bug_title;
    private String bug_description;
    //private State state; //Usar base de Datos
    //private Severity severity; //Usar base de Datos
    private LocalDateTime creation_date;
    private LocalDateTime update_date;


}
