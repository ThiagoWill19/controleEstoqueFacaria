package com.thiagowill.controleEstoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagowill.controleEstoque.models.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	List<Funcionario> findByNomeIgnoreCaseContaining(String nome);
}
