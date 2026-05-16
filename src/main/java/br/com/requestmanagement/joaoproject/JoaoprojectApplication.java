package br.com.requestmanagement.joaoproject;

import br.com.requestmanagement.joaoproject.model.Main;
import br.com.requestmanagement.joaoproject.repository.CategoryRepository;
import br.com.requestmanagement.joaoproject.repository.ProductRepository;
import br.com.requestmanagement.joaoproject.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JoaoprojectApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private RequestRepository requestRepository;

	public static void main(String[] args) {
		SpringApplication.run(JoaoprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running");

		Main main = new Main(productRepository, categoryRepository, requestRepository);
		main.menu();

	}
}
