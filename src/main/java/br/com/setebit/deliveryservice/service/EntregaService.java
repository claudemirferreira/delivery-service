package br.com.setebit.deliveryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.deliveryservice.domain.Entrega;
import br.com.setebit.deliveryservice.exception.EntregadorNotFoundException;
import br.com.setebit.deliveryservice.exception.NoDataFoundException;
import br.com.setebit.deliveryservice.repository.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	EntregaRepository repository;

	public Entrega findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntregadorNotFoundException(id));
	}

	public List<Entrega> findAll() {
		List<Entrega> lista = repository.findAll();
		if (lista.isEmpty()) {
			throw new NoDataFoundException();
		}
		return lista;
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	public void delete(Entrega entity) {
		repository.delete(entity);
	}

	public Entrega save(Entrega entity) {
		return repository.save(entity);
	}

}
