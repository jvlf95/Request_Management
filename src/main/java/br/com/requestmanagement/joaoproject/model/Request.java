package br.com.requestmanagement.joaoproject.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @Transient
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_requests",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList = new ArrayList<>();



    public Request(){}

    public Request(LocalDate date){
        this.date = date;
    }

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product){
        this.productList.add(product);
    }


}
