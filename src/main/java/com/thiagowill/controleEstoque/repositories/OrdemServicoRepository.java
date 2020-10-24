package com.thiagowill.controleEstoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagowill.controleEstoque.models.OrdemServico;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {
	List<OrdemServico> findByEmpresaIgnoreCaseContaining(String empresa);
}
