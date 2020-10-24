package com.thiagowill.controleEstoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thiagowill.controleEstoque.services.ControleProducaoService;

@Controller
public class ControleProducaoController {

	@Autowired
	ControleProducaoService cps;
	
	
	@GetMapping(value = "/controleProducao")
	public ModelAndView controleProducaoView() {
		ModelAndView mv = new ModelAndView("ControleProducao");
		return mv;
	}
	
	@PostMapping(value = "/controleProducao")
	public String getIds(int idF, int idO,String opc, RedirectAttributes attributes) {	
		
		try {
			if(opc.equals("CONCLUIR")) {
				cps.concluirServico(idO, idF);
			}else {
				cps.entradaDeServico(idO, idF);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/facaria/ordens/ordemdetalhe"+idO;
	}
		
	

}
