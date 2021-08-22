package br.com.setebit.deliveryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.deliveryservice.domain.Entregador;
import br.com.setebit.deliveryservice.exception.EntregadorNotFoundException;
import br.com.setebit.deliveryservice.exception.NoDataFoundException;
import br.com.setebit.deliveryservice.repository.EntregadorRepository;

@Service
public class EntregadorService {

	@Autowired
	EntregadorRepository repository;

	public Entregador findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntregadorNotFoundException(id));
	}

	public List<Entregador> findAll() {
		List<Entregador> lista = repository.findAll();
		if (lista.isEmpty()) {
		    throw new NoDataFoundException();
		}
		return lista;
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	public void delete(Entregador entity) {
		repository.delete(entity);
	}

	public Entregador save(Entregador entity) {
		return repository.save(entity);

	}

}
