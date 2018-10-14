package com.estudo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.estudo.spring.model.Evento;
import com.estudo.spring.repository.EventoRepository;


@RestController
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;
	

	

	@RequestMapping(method=RequestMethod.POST,value="/cadastrarevento")
	public ModelAndView form(Evento evento) {
		ModelAndView mv=new ModelAndView("/evento/listaeventos");
		eventoRepository.save(evento);
		
		return mv;

	}


	

	@RequestMapping(method=RequestMethod.GET,value="/listaev")
	public ModelAndView listaEventos()
	{

		ModelAndView mv=new ModelAndView("/evento/listaeventos");
		Iterable<Evento> eventos = eventoRepository.findAll();
		mv.addObject("eventos",eventos);
		return mv;
		
		
	}
	
}
