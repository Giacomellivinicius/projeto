package com.vinicius.mc.dto;

import java.io.Serializable;

import com.vinicius.mc.domain.Produto;

public class ProdutoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Double preco;
	
	//Construtores
	
	public ProdutoDTO() {}

	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		preco = obj.getPreco();
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	

	
	
	
	
	
}
