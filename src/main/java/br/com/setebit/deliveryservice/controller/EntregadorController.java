package br.com.setebit.deliveryservice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.deliveryservice.domain.Entregador;
import br.com.setebit.deliveryservice.dto.EntregadorDTO;
import br.com.setebit.deliveryservice.service.EntregadorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/delivery/entregador/")
public class EntregadorController {

	@Autowired
	EntregadorService service;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Entregador>> find(
			@RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
			@RequestParam(value = "nome", required = false, defaultValue = "") String nome) {
		EntregadorDTO dto = EntregadorDTO.builder().id(id).nome(nome).build();
		return ResponseEntity.ok(service.find(dto));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Entregador> findById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		try {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Entregador> save(HttpServletResponse resp, @Valid @RequestBody Entregador obj) {
		return ResponseEntity.ok(service.save(obj));
	}
}