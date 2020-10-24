package com.thiagowill.controleEstoque.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagowill.controleEstoque.models.Madeira;
import com.thiagowill.controleEstoque.models.PedidoMadeira;
import com.thiagowill.controleEstoque.repositories.MadeiraRepository;
import com.thiagowill.controleEstoque.repositories.PedidoMadeiraRepository;

@Service
public class MadeiraService {

	@Autowired
	private MadeiraRepository repo;
	@Autowired
	private PedidoMadeiraRepository pedidoRepo;
	@Autowired
	private EmailService mailService;

	public ArrayList<Madeira> findAll() {
		ArrayList<Madeira> list = new ArrayList<>();
		list = (ArrayList<Madeira>) repo.findAll();
		return list;
	}
	
	public Madeira findById(int id) {
		Optional<Madeira> madeira = repo.findById(id);
		return madeira.get();

	}

	public boolean retirada(int id) {
		Optional<Madeira> madeira = repo.findById(id);
		if (madeira.get().getQuantidade() - 1 >= 0) {
			madeira.get().setQuantidade(madeira.get().getQuantidade() - 1);
			repo.save(madeira.get());
			return true;
		}
		return false;

	}

	public void save(Madeira madeira) {
		repo.save(madeira);
	}
	
	public void delete(int id){
		repo.deleteById(id);
	}

	public ArrayList<Madeira> verificarEstoque() {

		ArrayList<Madeira> listaParaPedido = new ArrayList<>();

		for (Madeira madeira : findAll()) {
			madeira.setQuantidade(10 - madeira.getQuantidade());
			if(madeira.getQuantidade() < 0) madeira.setQuantidade(0);
			listaParaPedido.add(madeira);
		}

		return listaParaPedido;
	}

	public boolean EnviarPedido(ArrayList<Madeira> listaPedido) {
		
		String listaPedidos = "";

		for (Madeira m : listaPedido) {
			if (m.getQuantidade() == 0) continue; // se quantidade a pedir for 0 não entra na lista;
			listaPedidos += m.getTipo() + "  Medida: " + m.getDimencoes() + "  Quantidade: " + m.getQuantidade()+ "\n\n";
		}
		if(listaPedidos.equals(""))return false;
		PedidoMadeira pedidoMadeira = new PedidoMadeira();
		pedidoMadeira.setListaPedido(listaPedidos);
		pedidoMadeira.setData("" + LocalDate.now());
		pedidoMadeira.setStatusEntrega(false);
		
		mailService.sendMail(listaPedidos);
		
		pedidoRepo.save(pedidoMadeira);
		
		return true;
	}
	
	public ArrayList<Madeira> itensDoEstoque() {

		ArrayList<Madeira> listaParaReposicao = new ArrayList<>();

		for (Madeira madeira : findAll()) {
			madeira.setQuantidade(0);
			listaParaReposicao.add(madeira);
		}

		return listaParaReposicao;
	}
	
	public void entradaEstoque(ArrayList<Madeira> listaPedido) {
		Optional<Madeira> madeira;
		for (Madeira m : listaPedido) {
			if (m.getQuantidade() != 0) {
				madeira = repo.findById(m.getId());
				madeira.get().setQuantidade(madeira.get().getQuantidade() + m.getQuantidade());
				save(madeira.get());
			}
				
		}
	}	

}
