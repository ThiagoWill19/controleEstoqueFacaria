package com.thiagowill.controleEstoque.resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thiagowill.controleEstoque.models.Ferramenta;
import com.thiagowill.controleEstoque.models.FerramentasWrapper;
import com.thiagowill.controleEstoque.services.FerramentaService;

@Controller
public class FerramentaController {

	@Autowired
	private FerramentaService service;
	
	@RequestMapping(value = "/ferramentas",method = RequestMethod.GET)
	public ModelAndView ferramentas() {
		ModelAndView mv = new ModelAndView("Ferramentas");
		mv.addObject("ferramentas",service.findAll());
		return mv;
	}

	@RequestMapping(value = "/ferramentas/ferramenta{id}",method = RequestMethod.GET)
	public ModelAndView buscarPorId(@PathVariable("id") int id) {
			ModelAndView mv = new ModelAndView("FerramentaDetalhe");
			mv.addObject("ferramenta",service.findById(id));
			return mv;
	}
	
	@RequestMapping(value = "/ferramentas/ferramenta{id}",method = RequestMethod.POST)
	public String alterar(Ferramenta ferramenta) {
		service.save(ferramenta);
		return "redirect:/ferramentas";
	}
	
	@RequestMapping(value = "/ferramentas/remover{id}",method = RequestMethod.GET)
	public String RemoverFerramenta(@PathVariable("id") int id) {
		service.delete(id);
		return "redirect:/ferramentas";
	}	
	
	@RequestMapping(value = "/ferramentas", method = RequestMethod.POST)
	public String novoItem(Ferramenta ferramenta) {
		service.save(ferramenta);
		return "redirect:/ferramentas";
	}
	
	@RequestMapping(value = "/ferramentas/retirar{id}", method = RequestMethod.GET)
	public String retirarItem(@PathVariable("id") int id) {
		service.retirarItem(id);
		return "redirect:/ferramentas";
	}
	
	@RequestMapping(value = "/ferramentas/reporestoque",method = RequestMethod.GET)
	public ModelAndView itensDoEstoque() {
		ArrayList<Ferramenta> ferramentas = new ArrayList<>();
		service.itensDoEstoque().iterator().forEachRemaining(ferramentas::add);
		ModelAndView mv = new ModelAndView("ReporEstoqueFerramentas");
		mv.addObject("ferramentasReposicao",new FerramentasWrapper(ferramentas));
		return mv;
	}
	
	@RequestMapping(value = "/ferramentas/reporestoque", method = RequestMethod.POST)
	public String entradaEstoque(@ModelAttribute("wrapper") FerramentasWrapper ferramentas) {
		service.entradaEstoque(ferramentas.getFerramentas());
		
		return "redirect:/ferramentas";

	}
	
	
}
