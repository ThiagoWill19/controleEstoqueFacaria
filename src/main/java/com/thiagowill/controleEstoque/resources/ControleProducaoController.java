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
	public String getIds(String idF,String idO,String opc, RedirectAttributes attributes) {	
		
		if(idF.isEmpty() || idO.isEmpty()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/controleProducao";
		}
		try {
			if(opc.equals("CONCLUIR")) {
				cps.concluirServico(Integer.parseInt(idO), Integer.parseInt(idF));
			}else {
				cps.entradaDeServico(Integer.parseInt(idO), Integer.parseInt(idF));
			}
		} catch (Exception e) {
			attributes.addFlashAttribute("mensagem", e.getMessage());
			return "redirect:/controleProducao";
		}
		attributes.addFlashAttribute("mensagemC", "Operação concluida!");
		return "redirect:/controleProducao";
	}
		
	

}
