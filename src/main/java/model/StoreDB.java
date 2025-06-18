package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="store")
public class StoreDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    @Column(unique = true)

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ManagerDB> managers;

    public List<ManagerDB> getManagers() {
        return managers;
    }

    private ArrayList<ProductDB> products;

    private ArrayList<BillDB> bills;
}
