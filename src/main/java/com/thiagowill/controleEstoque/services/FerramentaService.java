package com.thiagowill.controleEstoque.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagowill.controleEstoque.models.Ferramenta;
import com.thiagowill.controleEstoque.repositories.FerramentaRepository;

@Service
public class FerramentaService {

	@Autowired
	private FerramentaRepository repo;

	public List<Ferramenta> findAll() {
		return repo.findAll();
	}

	public Ferramenta findById(int id) {
		Optional<Ferramenta> ferramenta = repo.findById(id);
		return ferramenta.get();
	}

	public void save(Ferramenta ferramenta) {
		repo.save(ferramenta);
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public void retirarItem(int id) {
		Ferramenta ferramenta = findById(id);
		if (ferramenta.getQuantidade() > 0) {
			ferramenta.setQuantidade(ferramenta.getQuantidade() - 1);
		}
		save(ferramenta);
	}

	public ArrayList<Ferramenta> itensDoEstoque() {
		ArrayList<Ferramenta> itensParaReposicao = new ArrayList<>();
		for (Ferramenta f : findAll()) {
			f.setQuantidade(0);
			itensParaReposicao.add(f);
		}
		return itensParaReposicao;
	}

	public void entradaEstoque(ArrayList<Ferramenta> listaEntrada) {
		Ferramenta ferramenta;
		for (Ferramenta f : listaEntrada) {
			if (f.getQuantidade() != 0) {
				ferramenta = findById(f.getId());
				ferramenta.setQuantidade(ferramenta.getQuantidade() + f.getQuantidade());
				save(ferramenta);
			}
		}
	}

}
