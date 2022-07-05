package daw2.trabalho.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import daw2.trabalho.model.Chaves;
import daw2.trabalho.model.Emprestimo;
import daw2.trabalho.model.Situacao;
import daw2.trabalho.model.Usuario;
import daw2.trabalho.repository.ChavesRepository;
import daw2.trabalho.repository.EmprestimoRepository;
import daw2.trabalho.repository.UsuarioRepository;
import daw2.trabalho.service.ChavesService;
import daw2.trabalho.service.EmprestimoService;


@Controller
public class ChavesController {
	
	//public static final DateTimeFormatter dtf2 = DateTimeFormatter.RFC_1123_DATE_TIME;
	DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.MEDIUM);
	LocalDateTime dateTime = LocalDateTime.now();

	private static final Logger logger = LoggerFactory.getLogger(ChavesController.class);

	@Autowired
	private ChavesRepository chavesRepository;
	@Autowired
	private ChavesService chavesService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	@Autowired
	private EmprestimoService emprestimoService;
	
	@GetMapping("novaChave")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("novaChave");
		mv.addObject("chave", new Chaves());
		List<Chaves> lista = chavesRepository.findAll();
		mv.addObject("listachaves", lista);
		return mv;
	}

	@GetMapping("deletarChave")
	public ModelAndView getdelkey(Long chave_id) {
		Chaves chave = chavesRepository.findById(chave_id).get();
		chavesService.deleteChave(chave);
		ModelAndView mv = new ModelAndView("redirect:novaChave");
		return mv;
	}

	@PostMapping("novaChave")
	public ModelAndView regKey(Chaves chave) {
		ModelAndView mv = new ModelAndView("sucesso");
		if (chave.getSituacao() == null) {
			chave.setSituacao(Situacao.LIVRE);
			chavesService.saveChave(chave);
		} else {
			chavesService.deleteChave(chave);
		}
		return mv;
	}

	@GetMapping("/menuDeChaves")
	public ModelAndView menudaschaves() {
		List<Chaves> livres = chavesRepository.findBySituacaoNot(Situacao.PEGA);
		List<Chaves> pegas = chavesRepository.findBySituacaoNot(Situacao.LIVRE);
		ModelAndView mv = new ModelAndView("/menuDeChaves");
		mv.addObject("livres", livres);
		mv.addObject("pegas", pegas);
		return mv;
	}

	@PostMapping("/menuDeChaves")
	public ModelAndView alugar(String chave_id) {
		logger.trace("Entrou em MENU DE CHAVES{}", chave_id);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = usuarioRepository.findByUsername(username).get(0);
		Chaves chave = chavesRepository.findById((long) Integer.parseInt(chave_id)).get();
		Situacao situacao = chave.getSituacao();
		if (chave.getSituacao().equals(Situacao.PEGA)) {
			chave.setSituacao(Situacao.LIVRE);
		} else {
			chave.setSituacao(Situacao.PEGA);
		}
		chavesService.saveChave(chave);
		ModelAndView mv = new ModelAndView("redirect:menuDeChaves");
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setServidor(usuario.username);
		emprestimo.setAlugada(chave.getNomechave());
		LocalDateTime dateTime = LocalDateTime.now();
		emprestimo.setHora(dateTime.format(formatter));
		if (chave.getSituacao().equals(Situacao.PEGA))
			emprestimo.setAcao("PEGOU");
		if (chave.getSituacao().equals(Situacao.LIVRE))
			emprestimo.setAcao("DEVOLVEU");
		emprestimoService.saveEmprestimo(emprestimo);
		return mv;
	}
}
