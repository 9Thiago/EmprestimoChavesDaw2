package daw2.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import daw2.trabalho.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	
}
