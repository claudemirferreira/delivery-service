package br.com.setebit.deliveryservice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.deliveryservice.domain.Tipo;
import br.com.setebit.deliveryservice.response.Response;
import br.com.setebit.deliveryservice.service.TipoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/delivery/tipo/")
public class TipoController {

	@Autowired
	TipoService service;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Tipo>>> find() {
		Response<List<Tipo>> response = new Response<List<Tipo>>();
		response.setContent(service.findAll());
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Tipo>> save(@RequestBody Tipo tipo) {
		Response<Tipo> response = new Response<Tipo>();
		response.setContent(service.save(tipo));
		return ResponseEntity.ok(response);
	}

}