package br.com.requestmanagement.joaoproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(){}

    public Category(String name){
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
