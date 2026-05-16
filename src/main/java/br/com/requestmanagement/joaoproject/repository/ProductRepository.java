package br.com.requestmanagement.joaoproject.repository;

import br.com.requestmanagement.joaoproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
