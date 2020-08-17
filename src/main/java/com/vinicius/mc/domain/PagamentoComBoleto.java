package com.vinicius.mc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.vinicius.mc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{

	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	//Construtores
	
	public PagamentoComBoleto() {}
	
	public PagamentoComBoleto(Integer id,EstadoPagamento estado, Pedido pedido,Date dataVencimento, Date dataPagamento) {
		super(id,estado,pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	
	//Getters e Setters
	
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	

	
	
	
}
