package daw2.trabalho.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

	private static final Logger logger = LoggerFactory.getLogger(EmprestimoController.class);

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

	@GetMapping("emprestimosp")
	public ModelAndView pajiina(@PageableDefault(size = 4) Pageable pageable) {
		ModelAndView mv = new ModelAndView("emprestimosp");
		Page<Emprestimo> pagina = emprestimoRepository.findAll(pageable);
		mv.addObject("pagina", pagina);
		List<Integer> numerosPaginas = new ArrayList<>();
		for (int cont = 1; cont <= pagina.getTotalPages(); cont++) {
			numerosPaginas.add(cont);
			mv.addObject("numerosPaginas", numerosPaginas);
		}
		logger.trace("===pajiinaa===: {}", pagina);
		logger.trace("===pajiinaa===: {}", pagina.getContent());

		return mv;
	}

}