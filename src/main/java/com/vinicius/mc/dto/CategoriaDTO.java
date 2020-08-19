package com.vinicius.mc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.vinicius.mc.domain.Categoria;

public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull(message="Preenchimento Obrigatório")
	@Length(min=5, max=80, message="O nome deve conter entre 5 e 80 caracteres")
	private String nome;
	
	
	
	//Construtores
	
	public CategoriaDTO() {}
	
	public CategoriaDTO(Categoria obj) {
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
