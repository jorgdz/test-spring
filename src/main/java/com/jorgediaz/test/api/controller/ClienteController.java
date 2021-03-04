package com.jorgediaz.test.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorgediaz.test.entity.Cliente;
import com.jorgediaz.test.services.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService serviceCliente;
	
	@GetMapping(value = "/clientes", produces = "application/json")
	public ResponseEntity<?> findAll () {
		List<Cliente> clientes = this.serviceCliente.findAll();
		
		if (clientes.size() == 0) {
			Map<String, String> error = new HashMap<String, String>();
			error.put("message", "No se han encontrado resultados.");
			return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.body(error);
		}
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(clientes);
	}
	
	@GetMapping(value="/clientes/{id}", produces = "application/json")
	public ResponseEntity<?> findById (@PathVariable Long id) {
		Cliente cliente = this.serviceCliente.findById(id);
		if (cliente == null) {
			Map<String, String> error = new HashMap<String, String>();
			error.put("message", "No se ha encontrado el cliente con id " + id);
			return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(error);
		}
		
		return ResponseEntity
			.status(HttpStatus.FOUND)
			.body(cliente);
	}
	
	@PostMapping(value="/clientes", produces = "application/json")
	public ResponseEntity<Cliente> save (@RequestBody Cliente cliente) {
		Cliente clienteCreated = this.serviceCliente.addCliente(cliente);
		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(clienteCreated);
	}
}
