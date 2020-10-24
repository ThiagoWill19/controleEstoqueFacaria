package com.thiagowill.controleEstoque.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thiagowill.controleEstoque.models.Funcionario;
import com.thiagowill.controleEstoque.services.FuncionarioService;


@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
	@GetMapping(value = "/funcionarios")
	public ModelAndView funcionarios() {
		ModelAndView mv = new ModelAndView("Funcionarios");
		mv.addObject("funcionarios",service.findAll());
		return mv;
	}
	
	@PostMapping(value = "/funcionarios")
	public ModelAndView buscaPorNome( String nome) {
		ModelAndView mv = new ModelAndView("Funcionarios");
		List<Funcionario>f = service.procurarPorNome(nome);
		mv.addObject("funcionarios",f);
		return mv;
	}
	
	@GetMapping(value = "/funcionarios/cadastro")
	public ModelAndView cadastroFuncionarios() {
		ModelAndView mv = new ModelAndView("CadastroFuncionario");
		return mv;
	}
	
	@PostMapping(value = "/funcionarios/cadastro")
	public String cadastrarFuncionario(Funcionario funcionario) {
		service.save(funcionario);
		return "redirect:/funcionarios";
	}
	
	@GetMapping(value = "/funcionarios/funcionario{id}")
	public ModelAndView funcionarioDetalhe(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("FuncionarioDetalhe");
		mv.addObject("funcionario",service.findById(id));
		return mv;
	}
	
	@PostMapping(value = "/funcionarios/funcionario{id}")
	public String alterarFuncionario(Funcionario funcionario) {
		service.save(funcionario);
		return "redirect:/funcionarios";
	}
	
	 
	@GetMapping(value = "/funcionarios/remover{id}")
	public String removerFuncionario(@PathVariable("id") int id) {
		service.remove(id);
		return "redirect:/funcionarios";
	}
}
