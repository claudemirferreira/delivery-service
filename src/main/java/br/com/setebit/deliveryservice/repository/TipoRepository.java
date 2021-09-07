package br.com.setebit.deliveryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.deliveryservice.domain.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {
	
}