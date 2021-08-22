package br.com.setebit.deliveryservice.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.setebit.deliveryservice.enums.StatusEntregaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Entrega implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entrega_id")
	private Integer id;
	
	@Column(nullable = false)
	private OffsetDateTime data;
	
	@Column(length = 200)
	private String endereco;
	
	private BigDecimal valorEntrega;
	
	@Column(nullable = false)
	private BigDecimal valorEntregador;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private StatusEntregaEnum status;

}