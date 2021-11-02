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

import br.com.setebit.deliveryservice.domain.Empresa;
import br.com.setebit.deliveryservice.service.EmpresaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/delivery/empresa/")
public class EmpresaController {

	@Autowired
	EmpresaService service;
	
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empresa>> find() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> save(@RequestBody Empresa empresa) {
		return ResponseEntity.ok(service.save(empresa));
	}
}
