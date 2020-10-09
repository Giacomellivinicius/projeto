package com.vinicius.mc.dto;

import java.io.Serializable;

import com.vinicius.mc.domain.Cidade;
import com.vinicius.mc.domain.Estado;

public class CidadeDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String nome;
	
	
	//Construtores
	
	public CidadeDTO() {}
	
	public CidadeDTO(Cidade obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
	}
	
	//Getters e Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
}
