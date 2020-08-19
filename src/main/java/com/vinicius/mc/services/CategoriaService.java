package com.vinicius.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vinicius.mc.domain.Categoria;
import com.vinicius.mc.repositories.CategoriaRepository;
import com.vinicius.mc.services.exception.DataIntegrityException;
import com.vinicius.mc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	//Essa anotação faz com que a dependência seja
	//automaticamente instanciada pelo spring
	private CategoriaRepository repo ;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		//Método .findById() herdado da classe JpaRepository
		//Substitui o antigo método .findOne()
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: "+id+", Tipo: "
				+Categoria.class.getName()));
			}
	
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria com produtos associados");
		}
		
	}
	
	
	
	
	
	
	
}
