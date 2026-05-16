package br.com.requestmanagement.joaoproject.model;

import br.com.requestmanagement.joaoproject.repository.CategoryRepository;
import br.com.requestmanagement.joaoproject.repository.ProductRepository;
import br.com.requestmanagement.joaoproject.repository.RequestRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner read = new Scanner(System.in);
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private RequestRepository requestRepository;

    public Main(ProductRepository productRepository, CategoryRepository categoryRepository, RequestRepository requestRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.requestRepository = requestRepository;
    }

    public void menu(){

        int option = -1;

        while(option != 0){
            System.out.println("""
                Choose one of the options down bellow:
                1 - Add a new product
                2 - Check all products
                
                0 - Exit
                """);
            System.out.print("Option: ");
            option = read.nextInt();
            read.nextLine();

            switch(option){
                case 1:
                    addProduct();
                    break;
                case 2:
                    listProducts();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("[ERROR] Invalid option!");
                    break;
            }
        }


    }

    private void addProduct(){
        System.out.println("Write the product's name and its price: ");
        System.out.print("Name: ");
        String productName = read.nextLine();
        System.out.print("Price: ");
        double productPrice = read.nextDouble();
        read.nextLine();

        Product product = new Product(productName, productPrice);

        System.out.println("Now, write the product's category: ");
        System.out.print("Category: ");
        String categoryName = read.nextLine();

        Category category = new Category(categoryName);

        LocalDate date = LocalDate.now();
        Request request = new Request(date);

        productRepository.save(product);
        categoryRepository.save(category);
        requestRepository.save(request);
    }

    private void listProducts(){
        List<Product> productList = productRepository.findAll();

        productList.stream()
                .sorted(Comparator.comparing(Product::getName))
                .forEach(System.out::println);
    }
}
