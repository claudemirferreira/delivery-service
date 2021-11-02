package br.com.setebit.deliveryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import br.com.setebit.deliveryservice.domain.Caixa;
import br.com.setebit.deliveryservice.repository.CaixaRepository;

@Service
public class CaixaService {

	@Autowired
	CaixaRepository repository;

	public Caixa findById(Integer id) {
		return repository.findById(id).get();
	}

	public List<Caixa> findAll() {
		List<Caixa> lista = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		return lista;
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	public void delete(Caixa entity) {
		repository.delete(entity);
	}

	public Caixa save(Caixa entity) {
		return repository.save(entity);

	}
}