package com.estudo.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estudo.spring.model.Evento;

@Repository
@Transactional
public interface EventoRepository extends CrudRepository<Evento,Long>{

	
	
	Evento findByCodigo(Long codigo);
	List<Evento> findByNome(@Param("nome") String nome);
//	Evento findByNomeAndData(@Param("nome")String nome,String data);
	
	
}
