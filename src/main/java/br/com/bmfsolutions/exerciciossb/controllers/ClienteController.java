package br.com.bmfsolutions.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmfsolutions.exerciciossb.model.entities.Cliente;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@GetMapping("qualquer")
	public Cliente getCliente() {
		return new Cliente(28, "Pedro", "123.456.789-00");
	}
	
	@GetMapping("{id}")
	public Cliente getClientById1(@PathVariable int id) { // @PathVariable para usar a variável no parametro da URL
		return new Cliente(id, "Maria", "987.654.321-00");
	}

	@GetMapping
	public Cliente getClientById2(@RequestParam(name = "id", defaultValue = "19") long id) { // @RequestParam para usar a variável no parametro da URL
		return new Cliente(id, "João Augusto", "111.222.333-44");
	}
}
