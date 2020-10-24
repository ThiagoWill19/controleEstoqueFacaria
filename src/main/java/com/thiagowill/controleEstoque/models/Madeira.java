package com.thiagowill.controleEstoque.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "madeiras")
public class Madeira implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tipo;
	private String dimencoes;
	private int quantidade;
	
	public Madeira() {
		
	}

	public Madeira(int id, String tipo, String dimencoes, int quantidade) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.dimencoes = dimencoes;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDimencoes() {
		return dimencoes;
	}

	public void setDimencoes(String dimencoes) {
		this.dimencoes = dimencoes;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
		Madeira other = (Madeira) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
