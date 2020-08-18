package com.vinicius.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.mc.domain.Pedido;
import com.vinicius.mc.repositories.PedidoRepository;
import com.vinicius.mc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	//Essa anotação faz com que a dependência seja
	//automaticamente instanciada pelo spring
	private PedidoRepository repo ;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		//Método .findById() herdado da classe JpaRepository
		//Substitui o antigo método .findOne()
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: "+id+", Tipo: "
				+Pedido.class.getName()));
			}
	
	
	
}
