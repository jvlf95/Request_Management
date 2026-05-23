package br.com.requestmanagement.joaoproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Supplier(){}

    public Supplier(String name){
        this.name = name;
    }

    // getters and setters

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

}
