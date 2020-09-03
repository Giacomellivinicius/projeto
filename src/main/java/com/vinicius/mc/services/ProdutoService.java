package com.vinicius.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vinicius.mc.domain.Categoria;
import com.vinicius.mc.domain.Produto;
import com.vinicius.mc.repositories.CategoriaRepository;
import com.vinicius.mc.repositories.ProdutoRepository;
import com.vinicius.mc.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	//Essa anotação faz com que a dependência seja
	//automaticamente instanciada pelo spring
	private ProdutoRepository repo ;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		//Método .findById() herdado da classe JpaRepository
		//Substitui o antigo método .findOne()
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: "+id+", Tipo: "
				+Produto.class.getName()));
			}
	
	public Page<Produto> search(String nome, List<Integer>ids,Integer page,Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.search(nome, categorias, pageRequest);
	}
	
	
}
