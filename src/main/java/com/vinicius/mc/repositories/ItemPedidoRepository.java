package com.vinicius.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.mc.domain.ItemPedido;

//JpaRepository<tipo, tipo do atributo identificador>
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Integer>{


}


