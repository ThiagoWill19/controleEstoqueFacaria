package com.thiagowill.controleEstoque.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "pedidos_madeira")
public class PedidoMadeira implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private final String nomePedido = "MADEIRA";
	private String data;
	private String listaPedido;
	private boolean statusEntrega;
	
	
	public PedidoMadeira() {
		super();
	}


	public PedidoMadeira(int id, String data, boolean statusEntrega) {
		super();
		this.id = id;
		this.data = data;
		this.statusEntrega = statusEntrega;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getListaPedido() {
		return listaPedido;
	}


	public void setListaPedido(String lisaPedido) {
		this.listaPedido = lisaPedido;
	}


	public boolean isStatusEntrega() {
		return statusEntrega;
	}


	public void setStatusEntrega(boolean statusEntrega) {
		this.statusEntrega = statusEntrega;
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
		PedidoMadeira other = (PedidoMadeira) obj;
		if (id != other.id)
			return false;
		return true;
	}


	public String getNomePedido() {
		return nomePedido;
	}


	
	
	
}
