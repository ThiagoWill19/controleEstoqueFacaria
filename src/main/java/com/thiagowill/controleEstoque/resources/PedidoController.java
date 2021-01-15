package com.thiagowill.controleEstoque.resources;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thiagowill.controleEstoque.models.PedidoMadeira;
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
	
	@GetMapping("/pedidos/{id}")
	public ModelAndView pedido( @PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("pedido.html");
		modelAndView.addObject("pedido",pedidoMadeiraService.findById(id));
		return modelAndView;
	}
	
	@PostMapping("/pedidos/{id}")
	public String alterarPedido( PedidoMadeira pedido) {
		
		pedidoMadeiraService.save(pedido);
		return "redirect : /pedidos";
	}
}
