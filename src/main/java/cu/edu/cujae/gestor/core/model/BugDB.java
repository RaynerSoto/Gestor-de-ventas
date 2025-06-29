package cu.edu.cujae.gestor.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "bug")
public class BugDB {
    @Id
    @Column(unique = true, length = 5)
    private String bug_id;
    @Column(unique = true)
    private String bug_title;
    private String bug_description;
    //private State state; //Usar base de Datos
    //private Severity severity; //Usar base de Datos
    private LocalDateTime creation_date;
    private LocalDateTime update_date;


}
