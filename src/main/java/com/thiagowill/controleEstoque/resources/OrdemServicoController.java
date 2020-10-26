package com.thiagowill.controleEstoque.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thiagowill.controleEstoque.models.OrdemServico;
import com.thiagowill.controleEstoque.services.OrdemServicoService;

@Controller
public class OrdemServicoController {

	@Autowired
	private OrdemServicoService ordemServicoService;
	
	@GetMapping(value = "/facaria/ordens")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("Ordens");
		mv.addObject("ordens",ordemServicoService.findAll());
		return mv;
	}
	@PostMapping(value = "/facaria/ordens")
	public ModelAndView filtrarPorEmpresa(String empresa){
		ModelAndView mv = new ModelAndView("Ordens");
		mv.addObject("ordens", ordemServicoService.bucarPorEmpresa(empresa));
		return mv;
	}
	
	@GetMapping(value = "/facaria/ordens/ordemdetalhe{id}")
	public ModelAndView ordemDetalhe(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("OrdemDetalhe");
		mv.addObject("ordem",ordemServicoService.findById(id));
		return mv;
	}
	
	
	@PostMapping(value = "/facaria/ordens/ordemdetalhe{id}")
	public String alterarOrdem(@Valid OrdemServico ordem,
			BindingResult result, RedirectAttributes attributes){
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/facaria/ordens/ordemdetalhe{id}";
		}
		
		try {
			ordem.setFuncionariosRelacionados(ordemServicoService.findById(ordem.getId()).getFuncionariosRelacionados());
			ordemServicoService.save(ordem);
		}catch (Exception e) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return " redirect:/facaria/ordens/ordemdetalhe{id}";
		}
		return"redirect:/facaria/ordens/";
	}
	
	@GetMapping(value = "/facaria/ordens/remover{id}")
	public String removerOrdem(@PathVariable("id") int id , RedirectAttributes attributes) {
		ordemServicoService.removeById(id);
		attributes.addFlashAttribute("mensagem", "O.S N°: " + id +" Removida!");
		return "redirect:/facaria/ordens";
	}
	
	@GetMapping(value = "/facaria/ordens/novaordem")
	public ModelAndView novaOrdem() {
		OrdemServico ordem = new OrdemServico();
		ModelAndView mv = new ModelAndView("OrdemCadastro");
		mv.addObject("ordem", ordem);
		return mv;
	}
	
	@PostMapping(value = "/facaria/ordens/novaordem")
	public String SalvarOrdem(@Valid OrdemServico ordem,
			BindingResult result, RedirectAttributes attributes){
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/facaria/ordens/novaordem";
		}
		
		try {
			ordemServicoService.save(ordem);
		}catch (Exception e) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return " redirect:/facaria/ordens/novaordem";
		}

		return"redirect:/facaria/ordens/";
	}
	
	
}
