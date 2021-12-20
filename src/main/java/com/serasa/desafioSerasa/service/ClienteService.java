package com.serasa.desafioSerasa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.desafioSerasa.model.Cliente;
import com.serasa.desafioSerasa.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	/*
	 * public Cliente InserirDados (Cliente cliente) { return
	 * repository.save(cliente); }
	 */
	
	public Optional<Cliente> InserirDados (Cliente cliente) {
	
		return Optional.ofNullable(repository.save(cliente));
	}
	
	//
}
