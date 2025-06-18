package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class BugDB {
    //Setters y Getters
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String description;
    private String priority;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "tester_id")
    private TesterDB tester;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "software_id")
    private SoftwareDB software;

    //Constructores
    public BugDB(){}

    public BugDB(Bug bug){
        this.title = bug.title();
        this.description = bug.description();
        this.priority = bug.priority();
    }

    //Setters y Getters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
}
