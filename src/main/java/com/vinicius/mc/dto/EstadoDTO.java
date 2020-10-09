package com.vinicius.mc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vinicius.mc.domain.Cidade;
import com.vinicius.mc.domain.Estado;

public class EstadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private List<Cidade> cidades = new ArrayList<>();
	
	//Construtores
	
	
	public EstadoDTO() {}
	
	public EstadoDTO(Estado obj) {
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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	
}
