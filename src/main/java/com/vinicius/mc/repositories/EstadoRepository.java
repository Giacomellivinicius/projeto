package com.vinicius.mc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinicius.mc.domain.Estado;

//JpaRepository<tipo, tipo do atributo identificador>
@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer>{


	@Transactional(readOnly=true)
	public List<Estado> findAllByOrderByNome();
}


