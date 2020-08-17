package com.vinicius.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.mc.domain.Cliente;
import com.vinicius.mc.repositories.ClienteRepository;
import com.vinicius.mc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	//Essa anotação faz com que a dependência seja
	//automaticamente instanciada pelo spring
	private ClienteRepository repo ;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		//Método .findById() herdado da classe JpaRepository
		//Substitui o antigo método .findOne()
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: "+id+", Tipo: "
				+Cliente.class.getName()));
			}
	
	
	
}
