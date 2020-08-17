package com.vinicius.mc.domain;

import javax.persistence.Entity;

import com.vinicius.mc.domain.enums.EstadoPagamento;


@Entity
public class PagamentoComCartao extends Pagamento{

	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;
	
	
	//Construtores
	public PagamentoComCartao() {}
	
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido,Integer n) {
		super(id,estado,pedido);
		this.numeroDeParcelas = n;
	}

	//Getters e Setters
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
