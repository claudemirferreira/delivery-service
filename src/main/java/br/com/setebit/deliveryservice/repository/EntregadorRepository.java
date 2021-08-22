package br.com.setebit.deliveryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.deliveryservice.domain.Entregador;

public interface EntregadorRepository extends JpaRepository<Entregador, Integer> {

}