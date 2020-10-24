package com.thiagowill.controleEstoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagowill.controleEstoque.models.OrdemServico;
import com.thiagowill.controleEstoque.repositories.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	public void save(OrdemServico ordemServico)throws Exception {
		if(ordemServico == null) throw new NullPointerException("Ordem de serviço nulla!");
		ordemServicoRepository.save(ordemServico);
	}
	
	public List<OrdemServico> findAll() {
		return ordemServicoRepository.findAll();
	}
	
	public OrdemServico findById(int id) {
		 return ordemServicoRepository.findById(id).get();
		
	}
	
	public void removeById(int id) {
		ordemServicoRepository.deleteById(id);
	}
	
	
	public List<OrdemServico> bucarPorEmpresa( String empresa){
		
		return ordemServicoRepository.findByEmpresaIgnoreCaseContaining(empresa);
	}
	

}
