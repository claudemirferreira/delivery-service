package br.com.setebit.deliveryservice.service;

import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import br.com.setebit.deliveryservice.domain.Caixa;
import br.com.setebit.deliveryservice.domain.Entrega;
import br.com.setebit.deliveryservice.domain.Entregador;
import br.com.setebit.deliveryservice.dto.EntregaResumoDTO;
import br.com.setebit.deliveryservice.exception.EntregadorNotFoundException;
import br.com.setebit.deliveryservice.exception.NoDataFoundException;
import br.com.setebit.deliveryservice.repository.EntregaRepository;
import br.com.setebit.deliveryservice.util.ExcelHelper;

@Service
public class EntregaService {
	
	@Autowired
	EntregaRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
	
	public ByteArrayInputStream load() {
	    List<Entrega> tutorials = repository.findAll();
	    ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
	    return in;
	  }
	
	public ByteArrayInputStream exportEntregar(Integer caixaId, Integer entregadorId) {
		if(null == entregadorId) {
			List<Entrega> tutorials = repository.findByCaixa(Caixa.builder().id(caixaId).build());
			return ExcelHelper.tutorialsToExcel(tutorials);
		}
	    List<Entrega> tutorials = repository.findByCaixaAndEntregador(Caixa.builder().id(caixaId).build(), 
	    		Entregador.builder().id(entregadorId).build());
	    return ExcelHelper.tutorialsToExcel(tutorials);
	  }
	
	public List<EntregaResumoDTO> buscarResumo(Integer caixaId) {

        String SQL_RESUMO = " SELECT caixa_id, a.entregador_id, b.nome, sum(taxa) totalTaxa "
    			+ " FROM entrega a, entregador b \n"
    			+ " where a.entregador_id = b.entregador_id \n"
    			+ " and a.caixa_id = " + caixaId 
    			+ " group by caixa_id, a.entregador_id, b.nome "
    			+ " order by nome ";

        return jdbcTemplate.query(
        		SQL_RESUMO,
        		new BeanPropertyRowMapper(EntregaResumoDTO.class)
        );
    }
	
	class EntregaResumoRowMapper implements RowMapper<EntregaResumoDTO> {

		@Override
	    public EntregaResumoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EntregaResumoDTO entity = new EntregaResumoDTO();
			entity.setCaixaId(rs.getInt("caixa_id"));
			entity.setEntregadorId(rs.getInt("entregador_id"));
			entity.setNome(rs.getString("nome"));
			entity.setTotalTaxa(rs.getBigDecimal("totalTaxa"));
	        return entity;
	    }
	}
}