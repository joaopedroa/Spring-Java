package br.com.projetospring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.projetospring.dao.ProdutoDao;
import br.com.projetospring.models.Produto;
import br.com.projetospring.models.TipoPreco;
import br.com.projetospring.validation.produtoValidation;

@Controller

public class cadastraController {
	
	@Autowired
	private ProdutoDao produtoDao;
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new produtoValidation());
		
	}
	
	@RequestMapping("/produtos/form")
	public ModelAndView form(Produto produto) {
		ModelAndView model = new ModelAndView("produtos/form");
		model.addObject("tipos",TipoPreco.values());
		
		return model;
	}

	@RequestMapping(value="/produtos",method = RequestMethod.POST)
	public ModelAndView gravar(@Valid Produto produto, BindingResult result, RedirectAttributes redAtributtes) {
		
		if(result.hasErrors()) {
			return form(produto);
		}
		
		produtoDao.gravar(produto);
		
		ModelAndView model = new ModelAndView("redirect:produtos");
		
		redAtributtes.addFlashAttribute("sucesso", "Produto " + produto.getTitulo() + " cadastrado com sucesso.");
		
		return model;
	}
	
	@RequestMapping(value="/produtos",method= RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView model = new ModelAndView("produtos/lista");
		model.addObject("produtos",produtos);
		return model;
	}
	
}
