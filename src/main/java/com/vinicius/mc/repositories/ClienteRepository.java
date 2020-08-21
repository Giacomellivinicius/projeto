package com.vinicius.mc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinicius.mc.domain.Cliente;

//JpaRepository<tipo, tipo do atributo identificador>
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
}


