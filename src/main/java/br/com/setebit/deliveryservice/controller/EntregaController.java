package br.com.setebit.deliveryservice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.setebit.deliveryservice.domain.Entrega;
import br.com.setebit.deliveryservice.dto.EntregaResumoDTO;
import br.com.setebit.deliveryservice.service.EntregaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/delivery/entrega/")
public class EntregaController {

	@Autowired
	EntregaService service;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Entrega>> find() {
		return ResponseEntity.ok(service.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Entrega> findById(@PathVariable("id") Integer id) {
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
	public ResponseEntity<Entrega> save(HttpServletResponse resp, @Valid @RequestBody Entrega obj) {
		return ResponseEntity.ok(service.save(obj));
	}

	@GetMapping("/download/{caixaId}/{entregadorId}")
	public ResponseEntity<Resource> getFile(@PathVariable("caixaId") Integer caixaId, @PathVariable("entregadorId") Integer entregadorId) {
		String filename = "entregas.xlsx";
		InputStreamResource file = new InputStreamResource(service.exportEntregar(caixaId, entregadorId));

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}

	@RequestMapping(value = "resumo/{caixaId}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntregaResumoDTO>> buscarResumo(@PathVariable("caixaId") Integer caixaId) {
			return ResponseEntity.ok(service.buscarResumo(caixaId));
	}
}