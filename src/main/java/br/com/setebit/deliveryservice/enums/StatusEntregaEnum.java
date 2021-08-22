package br.com.setebit.deliveryservice.enums;

import java.util.Arrays;
import java.util.Optional;

public enum StatusEntregaEnum {
	CRIADO("1"),
	ENVIADO("2"),
	ENTREGUE("3"),
	CANCELADO("4");
	
	private String codigo;

	StatusEntregaEnum(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public static Optional<StatusEntregaEnum> fromCodigo(String codigo) {
		return Arrays.stream(values()).filter(bl -> bl.codigo.equals(codigo)).findFirst();
	}
}