package com.vinicius.mc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.mc.domain.Pedido;
import com.vinicius.mc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")//EndPoint
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	
	
	//@PAthVariable -> mostra onde o /{id} deve ser colocado
	//ResponseEntity -> encapsula/armazena informações de 
	//uma resposta http para um serviço REST 
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id ) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
