package com.serasa.desafioSerasa.model;


import java.time.LocalDate;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@NotBlank(message = "Campo obrigatório")
	private String telefone;

	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/*
	 * public LocalDate getDataNascimento() { return dataNascimento; }
	 * 
	 * public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento
	 * = dataNascimento; }
	 */
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
