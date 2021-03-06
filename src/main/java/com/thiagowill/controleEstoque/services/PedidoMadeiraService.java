package com.thiagowill.controleEstoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagowill.controleEstoque.models.PedidoMadeira;
import com.thiagowill.controleEstoque.repositories.PedidoMadeiraRepository;

@Service
public class PedidoMadeiraService {
	
	@Autowired
	private PedidoMadeiraRepository pedidoMadeiraRepository;
	
	public List<PedidoMadeira> findAll(){
		return pedidoMadeiraRepository.findAll();
	}
	
	public PedidoMadeira findById(int id) {
		Optional<PedidoMadeira> pedido  = pedidoMadeiraRepository.findById(id);
		return pedido.get();
	}
	
	public List<PedidoMadeira> AguardandoEntrega(){
		return pedidoMadeiraRepository.findByStatusEntrega(false);
	}
	
	public void save(PedidoMadeira pedido) {
		pedidoMadeiraRepository.save(pedido);
	}
}
