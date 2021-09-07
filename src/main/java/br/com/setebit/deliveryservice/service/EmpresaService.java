package br.com.setebit.deliveryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.deliveryservice.domain.Empresa;
import br.com.setebit.deliveryservice.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository repository; 
	
	public List<Empresa> findAll() {
		return repository.findAll();
	}
	
	public Empresa save (Empresa empresa) {
		return repository.save(empresa);
	}
}
