package com.nelioalves.mc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Produto implements Serializable{

	
	private static final long SerialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Sem ;
	private Integer id;
	private String nome;
	private double preco;
	
	
	@ManyToMany
	//@jointable mapeia a tabela a ser criada na junção 
	//enquanto JoinColumn define a chave estrangeira
	@JoinTable(name = "Produto_Categoria",
		joinColumns = @JoinColumn(name = "produto_id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	public Produto() {
	}
	
	//Coleções [categorias<Categoria>] não devem fazer parte 
	//do contrutor com parâmetros.
	public Produto(Integer id, String nome, double preco) {
		super();
		this.setId(id);
		this.setNome(nome);
		this.setPreco(preco);
	}

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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	
	
}
