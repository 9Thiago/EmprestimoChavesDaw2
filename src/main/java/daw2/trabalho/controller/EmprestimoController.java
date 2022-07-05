package daw2.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import daw2.trabalho.model.Emprestimo;
import daw2.trabalho.repository.EmprestimoRepository;
import daw2.trabalho.repository.UsuarioRepository;
import daw2.trabalho.service.EmprestimoService;

@Controller
public class EmprestimoController {

	@Autowired
	private EmprestimoRepository emprestimoRepository;
	@Autowired
	private EmprestimoService emprestimoService;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("emprestimos")
	public ModelAndView listaemprestimos() {
		ModelAndView mv = new ModelAndView("emprestimos");
		mv.addObject("emprestimos", emprestimoRepository.findAll());
		return mv;
	}

	@PostMapping("emprestimos")
	public ModelAndView cadastro(Emprestimo emprestimo) {
		ModelAndView mv = new ModelAndView("sucesso");
		emprestimoService.saveEmprestimo(emprestimo);
		return mv;
	}
	
	
}