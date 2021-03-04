package com.jorgediaz.test.services;

import java.util.List;

import com.jorgediaz.test.entity.Cliente;

public interface ClienteService {
	
	Cliente addCliente (Cliente cliente);
	
	List<Cliente> findAll ();
	
	Cliente findById (Long id);
}
