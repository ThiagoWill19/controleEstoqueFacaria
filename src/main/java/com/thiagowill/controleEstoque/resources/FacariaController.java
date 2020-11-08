package com.thiagowill.controleEstoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thiagowill.controleEstoque.services.PedidoMadeiraService;



@Controller
public class FacariaController {
	
	@Autowired
	private PedidoMadeiraService pedidosMadeiraService;
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public ModelAndView inicial() {
		ModelAndView mv = new ModelAndView("Index");
		return mv;
	}
	
	@RequestMapping(value ="/facaria", method = RequestMethod.GET)
	public ModelAndView facaria() {
		ModelAndView mv = new ModelAndView("facaria");
		mv.addObject("pedidos",pedidosMadeiraService.AguardandoEntrega());
		return mv;
	}
}
