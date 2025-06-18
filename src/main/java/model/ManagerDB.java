package model;

import jakarta.persistence.ManyToOne;

public class ManagerDB {

    private String id;

    private String name;

    private double salary;

    @ManyToOne
    private StoreDB storeDB;

}
