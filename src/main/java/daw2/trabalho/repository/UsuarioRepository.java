package daw2.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import daw2.trabalho.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario>findByUsername(String username);
}

//public interface JuizRepository  extends JpaRepository<Juiz, Long> {
//
//	public List<Juiz>findBySituacaoNot(Situacao situacao); 
//	
//}