package daw2.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import daw2.trabalho.model.Chaves;
import daw2.trabalho.model.Situacao;

public interface ChavesRepository extends JpaRepository<Chaves, Long> {
	public List<Chaves>findBySituacaoNot(Situacao situacao); 
}
