package com.vinicius.mc.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.mc.domain.Cidade;
import com.vinicius.mc.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository repo;

	public List<Cidade> findByEstado(Integer estadoId){
		return repo.findCidades(estadoId);
	}

}
