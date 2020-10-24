package com.thiagowill.controleEstoque.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagowill.controleEstoque.models.Funcionario;
import com.thiagowill.controleEstoque.repositories.FuncionarioRepository;


@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	public ArrayList<Funcionario> findAll(){		
		return (ArrayList<Funcionario>) repo.findAll();
	}
	
	public Funcionario findById( int id) {
		return repo.findById(id).get();
	}
	
	public void save(Funcionario funcionario) {
		repo.save(funcionario);
	}
	
	public void remove(int id) {
		repo.deleteById(id);
	}
	
	public List<Funcionario> procurarPorNome(String nome) {
		return repo.findByNomeIgnoreCaseContaining(nome);
	}
	
}
