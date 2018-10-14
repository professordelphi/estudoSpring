package com.estudo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.spring.model.Evento;
import com.estudo.spring.repository.EventoRepository;


@RestController
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;
	

	

	@RequestMapping(method=RequestMethod.GET,value="/formEvento")
	public String form() {

		return "evento/formEvento";

	}


	@RequestMapping ( method=RequestMethod.POST, value="/cadastrarEvento")
	public String form(Evento evento)
	{
		eventoRepository.save(evento);
		
		return "redirect/cadastrarEvento";
	}

}
