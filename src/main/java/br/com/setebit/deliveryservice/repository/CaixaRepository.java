package br.com.setebit.deliveryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.deliveryservice.domain.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Integer> {
	
	public List<Caixa> findByStatus(String atatus);
	
}