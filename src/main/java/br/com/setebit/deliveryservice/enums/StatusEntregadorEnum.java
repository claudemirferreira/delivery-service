package br.com.setebit.deliveryservice.enums;

import java.util.Arrays;
import java.util.Optional;

public enum StatusEntregadorEnum {
	ATIVO("1"),
	INAATIVO("2");
	
	private String codigo;

	StatusEntregadorEnum(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public static Optional<StatusEntregadorEnum> fromCodigo(String codigo) {
		return Arrays.stream(values()).filter(bl -> bl.codigo.equals(codigo)).findFirst();
	}
}