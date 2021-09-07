package br.com.setebit.deliveryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.deliveryservice.domain.Tipo;
import br.com.setebit.deliveryservice.repository.TipoRepository;

@Service
public class TipoService {
	
	@Autowired
	TipoRepository repository;
	
	public List<Tipo> findAll() {
		return repository.findAll();
	}
	
	public Tipo save(Tipo tipo) {
		return repository.save(tipo);
	}

}