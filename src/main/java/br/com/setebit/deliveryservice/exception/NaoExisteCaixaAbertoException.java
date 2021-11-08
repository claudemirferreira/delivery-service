package br.com.setebit.deliveryservice.exception;

public class NaoExisteCaixaAbertoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NaoExisteCaixaAbertoException() {
        super("Não existe caixa aberto");
    }
}