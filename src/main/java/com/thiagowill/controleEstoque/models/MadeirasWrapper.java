package com.thiagowill.controleEstoque.models;

import java.util.ArrayList;

public class MadeirasWrapper {

	private ArrayList<Madeira> madeiras;
	
	public void addMadeira(Madeira madeira) {
		this.madeiras.add(madeira);
	}

	public ArrayList<Madeira> getMadeiras() {
		return madeiras;
	}

	public void setMadeiras(ArrayList<Madeira> madeiras) {
		this.madeiras = madeiras;
	}
	
	public MadeirasWrapper(ArrayList<Madeira> madeiras) {
		this.madeiras = madeiras;
	}
	
}
