package com.thiagowill.controleEstoque.exceptions;

public class FuncaoNaoReconhecidaException extends Exception {
	private static final long serialVersionUID = 1L;

	private String msg;
	
	public FuncaoNaoReconhecidaException() {
		super("O funcionário não tem uma função válida para o sistema!");
		this.msg = "O funcionário não tem uma função válida para o sistema!";
	}
	
	public String getMessage() {
		return msg;
	}
}
