package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "testers")
public class TesterDB {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Column(unique = true)
    private String name;
    @Getter
    @OneToMany(mappedBy = "tester", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BugDB> bugs;

    public void setBugs(List<BugDB> bugs){
        for(BugDB bugDB : bugs){
            bugs.forEach(l -> l.setTester(this));
            this.bugs = bugs;
        }
    }

    //Constructores
    public TesterDB(){}

    public TesterDB(Tester tester){
        setName(tester.name());
    }

    //Setters y Getters
    public String getName() {
        return name;
    }
}
