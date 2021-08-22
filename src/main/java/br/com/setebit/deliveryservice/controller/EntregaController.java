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

import br.com.setebit.deliveryservice.domain.Entrega;
import br.com.setebit.deliveryservice.response.Response;
import br.com.setebit.deliveryservice.service.EntregaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/delivery/entrega/")
public class EntregaController {
	
	@Autowired
	EntregaService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Entrega>>> find() {
		Response<List<Entrega>> response = new Response<List<Entrega>>();
		response.setContent(service.findAll());
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Entrega>> findById(@PathVariable("id") Integer id) {
		Response<Entrega> response = new Response<Entrega>();
		try {
			response.setContent(service.findById(id));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
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
	public ResponseEntity<Response<Entrega>> save(HttpServletResponse resp, @Valid @RequestBody Entrega obj) {

		Response<Entrega> response = new Response<Entrega>();
		try {
			Entrega entity = service.save(obj);
			response.setContent(entity);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(response);
		}
	}
}