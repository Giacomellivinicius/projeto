package com.nelioalves.mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.mc.domain.Categoria;

//JpaRepository<tipo, tipo do atributo identificador>
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{


}


