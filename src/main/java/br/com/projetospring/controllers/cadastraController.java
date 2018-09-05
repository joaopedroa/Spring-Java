package br.com.projetospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetospring.models.Produto;

@Controller

public class cadastraController {
	
	@RequestMapping("/produtos/form")
	public String form() {
		//jsp
		return "produtos/form";
	}

	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		System.out.println(produto.getTitulo());	
		
		
		return "produtos/ok";
	}
}
