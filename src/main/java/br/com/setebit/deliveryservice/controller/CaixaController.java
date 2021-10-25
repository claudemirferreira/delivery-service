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
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.deliveryservice.domain.Caixa;
import br.com.setebit.deliveryservice.service.CaixaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/delivery/caixa/")
public class CaixaController {

	@Autowired
	CaixaService service;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Caixa>> find() {
		return ResponseEntity.ok(service.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Caixa> findById(@PathVariable("id") Integer id) {
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
	public ResponseEntity<Caixa> save(HttpServletResponse resp, @Valid @RequestBody Caixa obj) {
		try {
			Caixa entity = service.save(obj);
			return ResponseEntity.ok(entity);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(obj);
		}
	}
}