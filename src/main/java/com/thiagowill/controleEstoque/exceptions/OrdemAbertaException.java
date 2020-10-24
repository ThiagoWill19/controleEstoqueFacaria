package com.thiagowill.controleEstoque.exceptions;

public class OrdemAbertaException extends Exception{
	private static final long serialVersionUID = 1L;

	private String msg;
	
	public OrdemAbertaException() {
		super("Esta O.S ja está aberta em outro processo!");
		this.msg = "Esta O.S ja está aberta em outro processo!";
	}
	
	public String getMessage() {
		return msg;
	}
}
