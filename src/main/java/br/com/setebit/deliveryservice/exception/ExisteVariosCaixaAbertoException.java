package br.com.setebit.deliveryservice.exception;

public class ExisteVariosCaixaAbertoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExisteVariosCaixaAbertoException() {
        super("Existem vários caixa aberto");
    }
}