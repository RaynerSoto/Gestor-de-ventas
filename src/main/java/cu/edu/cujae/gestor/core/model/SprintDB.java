package cu.edu.cujae.gestor.core.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SprintDB {
    @lombok.Setter
    @lombok.Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private LocalDateTime estimated_time;
    private LocalDateTime duration;
    private LocalDateTime creation_mounth;
}
