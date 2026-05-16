package br.com.requestmanagement.joaoproject.repository;

import br.com.requestmanagement.joaoproject.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
