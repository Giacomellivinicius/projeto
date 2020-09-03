package com.vinicius.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vinicius.mc.domain.Categoria;
import com.vinicius.mc.domain.Cliente;
import com.vinicius.mc.dto.CategoriaDTO;
import com.vinicius.mc.repositories.CategoriaRepository;
import com.vinicius.mc.services.exception.DataIntegrityException;
import com.vinicius.mc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	/*Método .findById() herdado da classe JpaRepository
	  Ssubstitui o antigo método .findOne();
	  @Autowired -> essa anotação faz com que a dependência
	   seja automaticamente instanciada pelo spring */
	
	
	@Autowired
	private CategoriaRepository repo ;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: "+id+", Tipo: "
				+Categoria.class.getName()));
			}
	
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria com produtos associados");
		}
		
	}
		
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
	PageRequest pageRequest = PageRequest.of(page,linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
		}
	
	public Categoria fromDto(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(),objDto.getNome());
	}
	
	public void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
	
	
	
	
	
	
	
	
}
