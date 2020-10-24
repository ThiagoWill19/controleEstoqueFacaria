package com.thiagowill.controleEstoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thiagowill.controleEstoque.models.Emails;
import com.thiagowill.controleEstoque.services.EmailPedidoService;

@Controller
public class ConfiguracaoController {
	
	@Autowired
	private EmailPedidoService emailService;
	
	@RequestMapping(value = "/facaria/configuracao", method = RequestMethod.GET)
	public ModelAndView paginaConfiguracao() {
		ModelAndView mv = new ModelAndView("Configuracao"); 
		Emails emails = emailService.findEmail();
		mv.addObject("emails",emails);
		return mv;
	}
	
	@RequestMapping(value = "/facaria/configuracao", method = RequestMethod.POST)
	public String alterarEmail( Emails emails) {
		emails.setId(emailService.findEmail().getId()); //para somente alterar o email;
		emailService.save(emails);
		return "redirect:/facaria/configuracao";
	}
}
