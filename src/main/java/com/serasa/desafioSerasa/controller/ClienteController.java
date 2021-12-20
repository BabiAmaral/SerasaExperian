package com.serasa.desafioSerasa.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.desafioSerasa.model.Cliente;
import com.serasa.desafioSerasa.repository.ClienteRepository;
import com.serasa.desafioSerasa.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> consultarTodos(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idCliente}")
	public ResponseEntity<Optional<Cliente>> consultarPorId(@PathVariable Long idCliente){	
		Optional<Cliente> clienteOptional = repository.findById(idCliente);
		
		if(clienteOptional.isPresent()) {
			return ResponseEntity.ok(repository.findById(idCliente));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

	@PostMapping("/inserir")
	public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody Cliente cliente){
		Optional<Cliente> objetoCadastrado = service.InserirDados(cliente);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	
	@DeleteMapping("/{idCliente}")
	public void delete(@PathVariable Long idCliente) {
		repository.deleteById(idCliente);
	}

}
