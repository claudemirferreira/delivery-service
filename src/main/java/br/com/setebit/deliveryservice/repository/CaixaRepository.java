package br.com.setebit.deliveryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.deliveryservice.domain.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Integer> {

}