package com.thiagowill.controleEstoque.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.thiagowill.controleEstoque.enums.Processos;

@Entity
public class OrdemServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String empresa;
	@NotBlank
	private String nomeDoTrabalho;
	private String descricao;
	@NotBlank
	private String tipo;
	private Processos processos;
	
	@OneToMany
	private List<Funcionario> funcionariosRelacionados = new ArrayList<>();
	
	@OneToOne
	private Funcionario funcionarioAtual;
	
	public OrdemServico() {
		super();
	}

	public OrdemServico(int id, String empresa, String nomeDoTrabalho, String descricao, String tipo,
			Processos processos) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.nomeDoTrabalho = nomeDoTrabalho;
		this.descricao = descricao;
		this.tipo = tipo;
		this.processos = processos;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNomeDoTrabalho() {
		return nomeDoTrabalho;
	}

	public void setNomeDoTrabalho(String nomeDoTrabalho) {
		this.nomeDoTrabalho = nomeDoTrabalho;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Processos getProcessos() {
		return processos;
	}

	public void setProcessos(Processos processos) {
		this.processos = processos;
	}

	public List<Funcionario> getFuncionariosRelacionados() {
		return funcionariosRelacionados;
	}

	public void setFuncionariosRelacionados(List<Funcionario> funcionariosRelacionados) {
		this.funcionariosRelacionados = funcionariosRelacionados;
	}
	

	public Funcionario getFuncionarioAtual() {
		return funcionarioAtual;
	}

	public void setFuncionarioAtual(Funcionario funcionarioAtual) {
		this.funcionarioAtual = funcionarioAtual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
