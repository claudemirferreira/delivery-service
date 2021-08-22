package br.com.setebit.deliveryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.deliveryservice.domain.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

}