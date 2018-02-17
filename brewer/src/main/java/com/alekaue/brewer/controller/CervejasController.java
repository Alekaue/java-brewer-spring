package com.alekaue.brewer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alekaue.brewer.controller.page.PageWrapper;
import com.alekaue.brewer.dto.CervejaDTO;
import com.alekaue.brewer.model.Cerveja;
import com.alekaue.brewer.model.Origem;
import com.alekaue.brewer.model.Sabor;
import com.alekaue.brewer.repository.Cervejas;
import com.alekaue.brewer.repository.Estilos;
import com.alekaue.brewer.repository.filter.CervejaFilter;
import com.alekaue.brewer.service.CadastroCervejaService;
import com.alekaue.brewer.service.exception.ImpossivelExcluirEntidadeException;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {

	@Autowired
	private Estilos estilos;

	@Autowired
	private CadastroCervejaService cadastroCervejaService;

	@Autowired
	private Cervejas cervejas;

	@RequestMapping("/nova")
	public ModelAndView nova(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cervejas/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}

	@RequestMapping(value = { "/nova", "{\\d+}"}, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Cerveja cerveja, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return nova(cerveja);
		}

		cadastroCervejaService.salvar(cerveja);

		attributes.addFlashAttribute("mensagem", "Cerveja cadastrada com sucesso!");

		return new ModelAndView("redirect:/cervejas/nova");
	}

	@GetMapping
	public ModelAndView pesquisar(CervejaFilter cervejaFilter, BindingResult result,
			@PageableDefault(size = 6) Pageable pageeable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("cervejas/PesquisaCerveja");
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("sabores", Sabor.values());
		mv.addObject("origens", Origem.values());

		PageWrapper<Cerveja> paginaWrapper = new PageWrapper<>(cervejas.filtrar(cervejaFilter, pageeable),
				httpServletRequest);
		mv.addObject("pagina", paginaWrapper);

		return mv;
	}

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CervejaDTO> pesquisar(String skuOuNome) {
		return cervejas.porSkuOuNome(skuOuNome);
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Cerveja cerveja){
		try{
			cadastroCervejaService.excluir(cerveja);
		}catch (ImpossivelExcluirEntidadeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Cerveja cerveja){
		ModelAndView mv = nova(cerveja);
		mv.addObject(cerveja);
		return mv;
	}

}
