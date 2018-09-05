package br.com.projetospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

	@RequestMapping("/")
	private String index() {
		System.out.println("Entrando...");
		// Não precisa colocar o jsp pois foi configurado um suffix no arquivo AppWebConfiguration.java
		return "home";
	}
	
}
