package com.thiagowill.controleEstoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thiagowill.controleEstoque.services.PedidoMadeiraService;

@Controller
public class PedidoController {

	@Autowired
	private PedidoMadeiraService pedidoMadeiraService;
	
	@GetMapping("/pedidos")
	public ModelAndView pedidos() {
		ModelAndView modelAndView = new ModelAndView("pedidos");
		modelAndView.addObject("pedidos",pedidoMadeiraService.findAll());
		return modelAndView;
	}
}
