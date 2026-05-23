package br.com.requestmanagement.joaoproject.model;

import br.com.requestmanagement.joaoproject.repository.CategoryRepository;
import br.com.requestmanagement.joaoproject.repository.ProductRepository;
import br.com.requestmanagement.joaoproject.repository.RequestRepository;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private Scanner read = new Scanner(System.in);
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private RequestRepository requestRepository;
    private List<Category> categoryList = new ArrayList<>();

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
                3 - Make a request
                
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
                case 3:
                    makeRequest();
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
        System.out.println("\nWrite the product's name and its price: ");
        System.out.print("Name: ");
        String productName = read.nextLine();
        System.out.print("Price: ");
        double productPrice = read.nextDouble();
        read.nextLine();

        Product product = new Product(productName, productPrice);

        System.out.println("Write the product's supplier");
        System.out.print("Name: ");
        String suplierName = read.nextLine();

        Supplier supplier = new Supplier(suplierName);

        System.out.println("Now, write the product's category: ");
        System.out.print("Category: ");
        String categoryName = read.nextLine();

        Category category = new Category(categoryName);

        product.addSupplier(supplier);

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        category.setProductList(productList);

        categoryRepository.save(category);
        System.out.println("Data saved!");
    }

    private void listProducts(){
        categoryList = categoryRepository.findAll();

        categoryList.stream()
                .sorted(Comparator.comparing(Category::getName))
                .forEach(System.out::println);
    }

    private void makeRequest(){
        listProducts();

        System.out.println("Choose one of the products above");
        System.out.print("Product: ");
        String productName = read.nextLine();

        Optional<Product> productFound = categoryList.stream()
                .flatMap(c -> c.getProductList().stream()
                        .filter(p -> p.getName().toLowerCase().contains(productName.toLowerCase())))
                .findFirst();

        if(productFound.isPresent()){
            var product = productFound.get();
            Request request = new Request(LocalDate.now());

            request.addProduct(product);

            requestRepository.save(request);
        }else{
            System.out.println("ERROR");
        }

    }

}
