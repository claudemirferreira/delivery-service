package br.com.setebit.deliveryservice.enums;

import java.util.Arrays;
import java.util.Optional;

public enum StatusCaixaEnum {
	ABERTO("1"),
	FECHADO("2");
	
	private String codigo;

	StatusCaixaEnum(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public static Optional<StatusCaixaEnum> fromCodigo(String codigo) {
		return Arrays.stream(values()).filter(bl -> bl.codigo.equals(codigo)).findFirst();
	}
}