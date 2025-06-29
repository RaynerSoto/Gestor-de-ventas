package cu.edu.cujae.gestor.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "testers")
public class TesterDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String first_name;
    private String last_name;

    /*
    public void setBugs(List<BugDB> bugs){
        for(BugDB bugDB : bugs){
            bugs.forEach(l -> l.setTester(this));
            this.bugs = bugs;
        }
    }
     */
}
