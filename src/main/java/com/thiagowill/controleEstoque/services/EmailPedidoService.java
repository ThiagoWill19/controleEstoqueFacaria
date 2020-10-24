package com.thiagowill.controleEstoque.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagowill.controleEstoque.models.Emails;
import com.thiagowill.controleEstoque.repositories.EmailPedidoRepository;

@Service
public class EmailPedidoService {

	@Autowired
	private EmailPedidoRepository repo;
	
	public void save(Emails emails) {
		repo.save(emails);
	}
	
	public void deletarEmail(int id) {
		repo.deleteById(id);
	}
	
	public Emails findEmail() {
		Emails emails;
		try {
			 emails =repo.findAll().get(0);
			return emails;
		} catch (Exception e) {
			
		}
		emails = new Emails();
		return emails;
		
	}
	
	
	
}
