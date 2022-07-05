package daw2.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import daw2.trabalho.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
	
}
