package br.com.setebit.deliveryservice.exception;

public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoDataFoundException() {
		super("No data found");
	}
}