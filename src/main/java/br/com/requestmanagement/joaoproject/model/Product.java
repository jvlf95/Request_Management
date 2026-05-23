package br.com.requestmanagement.joaoproject.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Transient
    @ManyToMany(mappedBy = "productList")
    private List<Product> productList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;


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

    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category = category;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Supplier getSupplier(){
        return supplier;
    }

    public void addSupplier(Supplier supplier){
        this.supplier = supplier;
    }

    @Override
    public String toString(){
        return  "\nProduct Name: " + name +
                "\nPrice: R$" + price +
                "\nSuplier: " + supplier.getName();
    }

}
