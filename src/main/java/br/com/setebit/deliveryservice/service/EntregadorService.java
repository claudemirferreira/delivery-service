package br.com.setebit.deliveryservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.deliveryservice.domain.Entregador;
import br.com.setebit.deliveryservice.dto.EntregadorDTO;
import br.com.setebit.deliveryservice.exception.EntregadorNotFoundException;
import br.com.setebit.deliveryservice.repository.EntregadorRepository;
import br.com.setebit.deliveryservice.util.StringUtil;

@Service
public class EntregadorService {

	@Autowired
	EntregadorRepository repository;

	@PersistenceContext
	private EntityManager entityManager;

	public Entregador findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntregadorNotFoundException(id));
	}

	public List<Entregador> findAll() {
		List<Entregador> lista = repository.findAll();

		return lista;
	}

	public List<Entregador> find(EntregadorDTO filtro) {
		StringBuilder sb = new StringBuilder();
		List<String> condictions = new ArrayList<String>();

		sb.append(" select l from Entregador l ");
		if (StringUtil.notEmpty(filtro)) {
			getCondictions(condictions, filtro);
		}

		String orderBy = " order by l.id ";
		Query query = entityManager.createQuery(StringUtil.generateHql(sb.toString(), condictions) + orderBy);

		if (StringUtil.notEmpty(filtro)) {
			setParameter(query, filtro);
		}
		return query.getResultList();
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

	private void getCondictions(List<String> condictions, EntregadorDTO filtro) {
		if (filtro.getId() > 0)
			condictions.add(" l.id = :id ");

		if (filtro.getNome().length() > 0)
			condictions.add(" UPPER(l.nome) like :nome");
		
		if (filtro.getStatus().length() > 0)
			condictions.add(" l.status = :status ");
	}

	private void setParameter(Query query, EntregadorDTO filtro) {
		if (filtro.getId() > 0)
			query.setParameter("id", filtro.getId());

		if (filtro.getNome().length() > 0)
			query.setParameter("nome", "%"+filtro.getNome().toUpperCase()+"%");

		if (filtro.getStatus().length() > 0)
			query.setParameter("status", filtro.getStatus());
	}

}
