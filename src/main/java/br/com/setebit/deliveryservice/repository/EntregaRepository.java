package br.com.setebit.deliveryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.deliveryservice.domain.Caixa;
import br.com.setebit.deliveryservice.domain.Entrega;
import br.com.setebit.deliveryservice.domain.Entregador;

public interface EntregaRepository extends JpaRepository<Entrega, Integer> {
	
	List<Entrega> findByCaixa(Caixa caixa);
	
	List<Entrega> findByCaixaAndEntregador(Caixa caixa, Entregador entregador);

}