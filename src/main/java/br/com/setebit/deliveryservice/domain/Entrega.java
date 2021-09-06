package br.com.setebit.deliveryservice.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Column(length = 60)
	private String numeroPedido;

	@Column(nullable = false)
	private OffsetDateTime data;

	@Column(length = 200)
	private String endereco;

	private BigDecimal valor;

	@Column(nullable = false)
	private BigDecimal taxa;

	@Column(length = 1, nullable = false)
	private String status;

	@ManyToOne
	@JoinColumn(name = "caixa_id")
	@JsonIgnore
	private Caixa caixa;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "entregador_id")
	// @JsonBackReference
	private Entregador entregador;

}