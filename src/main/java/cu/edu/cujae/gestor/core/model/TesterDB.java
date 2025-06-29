package cu.edu.cujae.gestor.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "testers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TesterDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String first_name;
    private String last_name;
}
