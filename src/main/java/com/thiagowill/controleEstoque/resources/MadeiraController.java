package com.thiagowill.controleEstoque.resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.thiagowill.controleEstoque.models.Madeira;
import com.thiagowill.controleEstoque.models.MadeirasWrapper;
import com.thiagowill.controleEstoque.services.MadeiraService;

@Controller
public class MadeiraController {

	@Autowired
	private MadeiraService service;

	@RequestMapping(value = "/madeiras", method = RequestMethod.GET)
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("Madeiras");
		mv.addObject("madeiras", service.findAll());
		return mv;
	}

	@RequestMapping(value = "/madeiras/{id}", method = RequestMethod.GET)
	public String fazerRetirada(@PathVariable("id") int id) {
		service.retirada(id);
		return "redirect:/madeiras";

	}

	@RequestMapping(value = "/madeiras", method = RequestMethod.POST)
	public String cadastrarMadeira(Madeira madeira) {
		if (!madeira.getDimencoes().isEmpty()) {
			service.save(madeira);
		}
		return "redirect:/madeiras";
	}

	@RequestMapping(value = "/madeiras/pedido", method = RequestMethod.GET)
	public ModelAndView verificarEstoque() {
		ArrayList<Madeira> madeiras = new ArrayList<>();
		service.verificarEstoque().iterator().forEachRemaining(madeiras::add);
		ModelAndView mv = new ModelAndView("MadeirasPedido");
		mv.addObject("madeirasReposicao", new MadeirasWrapper(madeiras));
		return mv;
	}

	@RequestMapping(value = "/madeiras/pedido", method = RequestMethod.POST)
	public String enviarPedido(@ModelAttribute("wrapper") MadeirasWrapper madeiras) {
		service.EnviarPedido(madeiras.getMadeiras());
		
		return "redirect:/madeiras";

	}
	
	@RequestMapping(value = "/madeiras/reporestoque", method = RequestMethod.GET)
	public ModelAndView itensDoEstoque() {
		ArrayList<Madeira> madeiras = new ArrayList<>();
		service.itensDoEstoque().iterator().forEachRemaining(madeiras::add);
		ModelAndView mv = new ModelAndView("ReporEstoque");
		mv.addObject("madeirasReposicao", new MadeirasWrapper(madeiras));
		return mv;
	}
	
	@RequestMapping(value = "/madeiras/reporestoque", method = RequestMethod.POST)
	public String entradaEstoque(@ModelAttribute("wrapper") MadeirasWrapper madeiras) {
		service.entradaEstoque(madeiras.getMadeiras());
		
		return "redirect:/madeiras";

	}
	
	@RequestMapping(value = "/madeiras/madeiradetalhe{id}", method = RequestMethod.GET)
	public ModelAndView madeiraDetalhes(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("MadeiraDetalhe");
		mv.addObject(service.findById(id));
		return mv;
	}
	
	@RequestMapping(value = "/madeiras/madeiradetalhe{id}", method = RequestMethod.POST)
	public String alterarMadeira(@ModelAttribute("madeira") Madeira madeira) {
		service.save(madeira);
		return "redirect:/madeiras";
	}
	
	@RequestMapping(value = "/madeiras/madeiradetalhe/remover{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		service.delete(id);
		return "redirect:/madeiras";
	}

}
