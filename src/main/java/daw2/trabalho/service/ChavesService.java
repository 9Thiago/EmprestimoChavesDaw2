package daw2.trabalho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import daw2.trabalho.model.Chaves;
import daw2.trabalho.repository.ChavesRepository;

@Service
public class ChavesService {

	@Autowired
	private ChavesRepository chavesRepository;

	// @Transactional
	public void saveChave(Chaves chave) {
		chavesRepository.save(chave);
	}

	public void deleteChave(Chaves chave) {
		chavesRepository.delete(chave);
	}

}
