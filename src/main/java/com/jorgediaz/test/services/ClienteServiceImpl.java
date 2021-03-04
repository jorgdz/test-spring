package com.jorgediaz.test.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.jorgediaz.test.entity.Cliente;
import com.jorgediaz.test.utils.Genero;

@Component
public class ClienteServiceImpl implements ClienteService{
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	@PostConstruct
	public void initial () {
		Cliente c1 = new Cliente ();
		c1.setCedula("1204125441");
		c1.setNombres("Juan");
		c1.setApellidos("Perez");
		c1.setId(1L);
		c1.setGenero(Genero.MASCULINO);
		c1.setFechaNacimiento(LocalDate.parse("1993-02-03"));
		c1.setCorreo("jperez@gmail.com");
		
		Cliente c2 = new Cliente ();
		c2.setCedula("1204155214");
		c2.setNombres("Carlos");
		c2.setApellidos("Monar");
		c2.setId(2L);
		c2.setGenero(Genero.MASCULINO);
		c2.setFechaNacimiento(LocalDate.parse("1994-02-03"));
		c2.setCorreo("cmonar@gmail.com");
		
		Cliente c3 = new Cliente ();
		c3.setCedula("1207144115");
		c3.setNombres("Jessica");
		c3.setApellidos("Velez");
		c3.setId(3L);
		c3.setGenero(Genero.FEMENINO);
		c3.setFechaNacimiento(LocalDate.parse("1995-07-03"));
		c3.setCorreo("jvelez1995@gmail.com");
		
		this.clientes.add(c1);
		this.clientes.add(c2);
		this.clientes.add(c3);
	}
	
	@Override
	public Cliente addCliente(Cliente cliente) {
		this.clientes.add(cliente);
		
		return this.clientes.stream()
			.filter(c -> c.getId() == cliente.getId())
			.findFirst()
			.get();
	}

	@Override
	public List<Cliente> findAll() {
		return this.clientes;
	}

	@Override
	public Cliente findById(Long id) {
		return this.clientes.stream()
			.filter(c -> c.getId() == id)
			.findAny()
			.orElse(null);
	}
}
