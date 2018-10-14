package com.estudo.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estudo.spring.model.Evento;

@Repository
@Transactional
public interface EventoRepository extends CrudRepository<Evento,String>{

}
