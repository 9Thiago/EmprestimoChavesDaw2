package daw2.trabalho.controller;

import java.util.List;
import java.util.function.IntToLongFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import daw2.trabalho.model.Roles;
import daw2.trabalho.model.User_role;
import daw2.trabalho.model.Usuario;
import daw2.trabalho.repository.RolesRepository;
import daw2.trabalho.repository.User_roleRepository;
import daw2.trabalho.repository.UsuarioRepository;
import daw2.trabalho.service.User_roleService;
import daw2.trabalho.service.UsuarioService;

@Controller
public class UsuarioController {

	private static final Logger logger = LoggerFactory.getLogger(ChavesController.class);

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private User_roleRepository user_roleRepository;
	@Autowired
	private User_roleService user_roleService;

	@GetMapping("criarConta")
	public ModelAndView pagCadastro() {
		ModelAndView mv = new ModelAndView("criarConta");
		List<Roles> roles = rolesRepository.findAll();
		mv.addObject("usuario", new Usuario());
		mv.addObject("allroles", roles);
		return mv;
	}

	@PostMapping("criarConta")
	public ModelAndView cadastro(Usuario usuario, Long roles) {
		logger.trace("===usuario=======: {}", usuario);
		logger.trace("====role id=======: {}", roles);
		ModelAndView mv = new ModelAndView("sucesso");
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setEnabled("true");
		usuarioService.saveUser(usuario);
		logger.trace("=usr com id do banco===: {}", usuario);
		User_role atrole = new User_role();
		atrole.setRole_id(roles);
		atrole.setUser_id(usuario.getId());
		logger.trace("===user role===: {}", atrole);
		user_roleService.savePapel(atrole);

		return mv;
	}

	@GetMapping("/gestaoUsuario")
	public ModelAndView listaUsuarios() {
		ModelAndView mv = new ModelAndView("/gestaoUsuario");
		mv.addObject("usuarios", usuarioRepository.findAll());
		return mv;
	}

	@PostMapping("gestaoUsuario")
	public ModelAndView deleteUser(Usuario usuario) {
		ModelAndView mv = new ModelAndView("redirect:gestaoUsuario");
		usuarioService.deleteUser(usuario);
		return mv;
	}
}
