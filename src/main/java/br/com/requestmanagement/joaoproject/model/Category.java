package br.com.requestmanagement.joaoproject.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> productList = new ArrayList<>();

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

    public List<Product> getProductList(){
        return productList;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setProductList(List<Product> productList){
        productList.forEach(p -> p.setCategory(this));
        this.productList = productList;
    }

    @Override
    public String toString(){
        return "\nCategory Name: " + this.name +
                "\nProducts: " +  this.productList;
    }
}
