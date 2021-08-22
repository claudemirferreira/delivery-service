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

import br.com.setebit.deliveryservice.domain.Entregador;
import br.com.setebit.deliveryservice.response.Response;
import br.com.setebit.deliveryservice.service.EntregadorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/delivery/entregador/")
public class EntregadorController {

	@Autowired
	EntregadorService service;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Entregador>>> find() {
		Response<List<Entregador>> response = new Response<List<Entregador>>();
		response.setContent(service.findAll());
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Entregador>> findById(@PathVariable("id") Integer id) {
		Response<Entregador> response = new Response<Entregador>();
		response.setContent(service.findById(id));
		return ResponseEntity.ok(response);
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
	public ResponseEntity<Response<Entregador>> save(HttpServletResponse resp, @Valid @RequestBody Entregador obj) {

		Response<Entregador> response = new Response<Entregador>();
		try {
			Entregador entity = service.save(obj);
			response.setContent(entity);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(response);
		}
	}
}