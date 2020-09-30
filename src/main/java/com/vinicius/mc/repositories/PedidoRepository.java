package com.vinicius.mc.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinicius.mc.domain.Cliente;
import com.vinicius.mc.domain.Pedido;

//JpaRepository<tipo, tipo do atributo identificador>
@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer>{

	@Transactional(readOnly=true)
	Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
		
}


