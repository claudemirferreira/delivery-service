package br.com.setebit.deliveryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.deliveryservice.domain.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
