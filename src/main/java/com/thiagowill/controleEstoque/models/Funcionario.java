package com.thiagowill.controleEstoque.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.thiagowill.controleEstoque.enums.Funcao;

@Entity
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private Funcao funcao;
	
	@ManyToOne
	private OrdemServico ordem;
	
	


	public Funcionario() {
		super();
	}


	public Funcionario(int id, String nome, Funcao funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Funcao getFuncao() {
		return funcao;
	}


	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public OrdemServico getOrdem() {
		return ordem;
	}


	public void setOrdem(OrdemServico ordem) {
		this.ordem = ordem;
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
		Funcionario other = (Funcionario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	public String toString() {
		return " "+this.funcao+": "+this.nome;
	}

}
