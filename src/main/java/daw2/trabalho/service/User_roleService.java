package daw2.trabalho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daw2.trabalho.model.User_role;
import daw2.trabalho.repository.User_roleRepository;

@Service
public class User_roleService {

	@Autowired
	private User_roleRepository user_roleRepository;

	// @Transactional
	public void savePapel(User_role user_role) {
		user_roleRepository.save(user_role);
	}

	public void saveandflushPapel(User_role user_role) {
		user_roleRepository.saveAndFlush(user_role);
	}
}
