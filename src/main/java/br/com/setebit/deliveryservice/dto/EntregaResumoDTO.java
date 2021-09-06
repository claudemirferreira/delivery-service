package br.com.setebit.deliveryservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntregaResumoDTO {
	
	private Integer caixaId;
	
	private Integer entregadorId;
	
	private String nome;
	
	private BigDecimal totalTaxa;
	
}