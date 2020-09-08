package com.vinicius.mc.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vinicius.mc.domain.Cidade;
import com.vinicius.mc.domain.Cliente;
import com.vinicius.mc.domain.Endereco;
import com.vinicius.mc.domain.enums.TipoCliente;
import com.vinicius.mc.dto.ClienteDTO;
import com.vinicius.mc.dto.ClienteNewDTO;
import com.vinicius.mc.repositories.CidadeRepository;
import com.vinicius.mc.repositories.ClienteRepository;
import com.vinicius.mc.repositories.EnderecoRepository;
import com.vinicius.mc.services.exception.DataIntegrityException;
import com.vinicius.mc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	//Essa anotação faz com que a dependência seja
	//automaticamente instanciada pelo spring
	@Autowired
	private ClienteRepository repo ;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		//Método .findById() herdado da classe JpaRepository
		//Substitui o antigo método .findOne()
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: "+id+", Tipo: "
				+Cliente.class.getName()));
			}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj,obj);
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
		
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
	PageRequest pageRequest = PageRequest.of(page,linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
		}
	
	public Cliente fromDto(ClienteDTO objDto) {
		return new Cliente(objDto.getId(),objDto.getNome(),objDto.getEmail(),null,null,null);
	}
	
	public Cliente fromDto(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null,objDto.getNome(),objDto.getEmail(),objDto.getCpfOuCnpj(),TipoCliente.toEnum(objDto.getTipo()),pe.encode(objDto.getSenha()));
		Cidade cid = new Cidade(objDto.getCidadeId(),null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(),objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if(objDto.getTelefone2()!= null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if(objDto.getTelefone3()!= null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}
	
	private void updateData(Cliente newObj,Cliente obj ) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	
	
	
	
	
}
