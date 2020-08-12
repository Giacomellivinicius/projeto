package com.nelioalves.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.Categoria;
import com.nelioalves.mc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	//Essa anotação faz com que a dependência seja
	//automaticamente instanciada pelo spring
	private CategoriaRepository repo ;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		//Método .findById() herdado da classe JpaRepository
		//Substitui o antigo método .findOne()
		return obj.orElse(null);
		
	}
	
	
	
}
