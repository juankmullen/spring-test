package com.jcastillo.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcastillo.web.app.models.Usuario;

@Controller
//@RequestMapping("/app")
public class IndexController {

	@RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo", "Juan carlos Castillo Brito");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("Juan Carlos");
		usuario.setApellido("Castillo Brito");
		usuario.setEmail("jccastillo.brito@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil Nuevo Usuario ".concat(usuario.getNombre()));
		return "perfil";

	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		
		model.addAttribute("titulo", "Listado de Usuarios");		
		return "listar";

	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(Model model) {

		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("JC", "Castillo", "brito@gmail.com"));
		usuarios.add(new Usuario("Francisaca", "Cntreras", "francisca@gmail.com"));
		usuarios.add(new Usuario("Javier", "Berrios", "javier@gmail.com"));
		
		return usuarios;
	}

}
