package br.com.requestmanagement.joaoproject.repository;

import br.com.requestmanagement.joaoproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
