package com.thiagowill.controleEstoque.models;

import java.util.ArrayList;

public class FerramentasWrapper {

	private ArrayList<Ferramenta> ferramentas;
	
	public FerramentasWrapper(ArrayList<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}
	
	public void addFerramenta(Ferramenta ferramenta) {
		this.ferramentas.add(ferramenta);
	}

	public ArrayList<Ferramenta> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(ArrayList<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}
	
	
}
