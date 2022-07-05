package daw2.trabalho.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daw2.trabalho.model.Usuario;
import daw2.trabalho.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//@Transactional
	public void saveUser(Usuario usuario) {
		usuarioRepository.save(usuario);
}
	public void deleteUser(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
}