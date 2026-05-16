package br.com.requestmanagement.joaoproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(name = "value")
    private Double price;

    public Product(){}

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }

    // getters and setters
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(Double price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "\nProduct Name: " + name +
                "\nPrice: R$" + price;
    }

}
