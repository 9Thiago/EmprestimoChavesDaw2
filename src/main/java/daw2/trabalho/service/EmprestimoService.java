package daw2.trabalho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daw2.trabalho.model.Emprestimo;
import daw2.trabalho.repository.EmprestimoRepository;


	@Service
	public class EmprestimoService {
		
		@Autowired
		private EmprestimoRepository emprestimoRepository;

		// @Transactional
		public void saveEmprestimo(Emprestimo emprestimo) {
			emprestimoRepository.save(emprestimo);
	}
}
	