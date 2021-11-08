package br.com.setebit.deliveryservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntregadorDTO {
	
	private Integer id;
	
	private String nome;
	
	private String status;

}