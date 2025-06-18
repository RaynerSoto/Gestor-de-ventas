package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class SoftwareDB {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "software", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BugDB> bugs;

    public void setBugs(List<BugDB> bugs){
        for(BugDB bugDB : bugs){
            bugs.forEach(bugDB1 -> bugDB1.setSoftware(this));
            this.bugs = bugs;
        }
    }

    //Constructores
    public SoftwareDB(){
    }
    public SoftwareDB(Software software){
        this.name = software.name();
    }
}
