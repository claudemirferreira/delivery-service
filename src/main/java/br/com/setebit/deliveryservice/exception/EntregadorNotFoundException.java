package br.com.setebit.deliveryservice.exception;

public class EntregadorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntregadorNotFoundException(Integer id) {
        super(String.format("Entregador with Id %d not found", id));
    }
}