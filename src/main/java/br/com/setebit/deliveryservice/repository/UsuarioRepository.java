package br.com.setebit.deliveryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.setebit.deliveryservice.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByLogin(String username);

}