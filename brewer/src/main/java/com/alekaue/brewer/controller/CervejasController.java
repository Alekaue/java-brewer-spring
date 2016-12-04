package com.alekaue.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alekaue.brewer.model.Cerveja;

@Controller 
public class CervejasController {
	
	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja){
		return "cervejas/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()) {
			return novo(cerveja);
		}	
		
		attributes.addFlashAttribute("mensagem", "Cerveja cadastrada com sucesso!");
		System.out.println("sku " + cerveja.getSku());
		System.out.println("Nome " + cerveja.getNome());
		System.out.println("Descricao " + cerveja.getDescricao());
		return "redirect:/cervejas/novo";
	}
	
	
}
