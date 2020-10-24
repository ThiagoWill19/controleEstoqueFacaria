package com.thiagowill.controleEstoque.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emails implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String emailDestino;
	
	public Emails() {
		
	}

	public Emails(int id, String emailDestino) {
		super();
		this.id = id;
		this.emailDestino = emailDestino;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailDestino() {
		return emailDestino;
	}

	public void setEmailDestino(String emailDestino) {
		this.emailDestino = emailDestino;
	}
	
	
	
	
}
