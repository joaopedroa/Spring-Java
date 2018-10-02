package br.com.projetospring.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.projetospring.models.Produto;

public class produtoValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		
		Produto produto = (Produto) target;
		
		if(produto.getPaginas() <= 0) {
			errors.rejectValue("paginas", "field.required");
		}
		
	}

	
	
}
