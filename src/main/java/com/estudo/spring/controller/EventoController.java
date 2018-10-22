package com.estudo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	/**
	 *  @return
	 *  
	 *  Apenas chama a tela de cadastro de evento - sem cadastrar
	 */
	@RequestMapping(method=RequestMethod.GET,value="/chamartelacadastroevento") //Define a url que quando for requisitada chamara o metodo
	public ModelAndView chamartelacadastroevento(){
		ModelAndView mv=new ModelAndView("evento/formevento");

		return mv;
	}

	/*
	 * Executa o cadastro de evento
	 * observação: O ModelAndView usado com o @RestController funcionou mas com o @Controller não funcionou
	 */
	@RequestMapping(method=RequestMethod.POST,value="/cadastrarEvento")
	public ModelAndView form(Evento evento) {
		ModelAndView mv=new ModelAndView("evento/listaeventos");
		eventoRepository.save(evento);

		return mv;

	}




	@RequestMapping(method=RequestMethod.GET,value="/listaev")
	public ModelAndView listaEventos()
	{

		ModelAndView mv=new ModelAndView("evento/listaeventos");
		Iterable<Evento> eventos = eventoRepository.findAll();
		mv.addObject("eventos",eventos);
		return mv;


	}


	
	/**
	 * O metodo detalhesEventos, recebe o valor do codigo do evento, localiza atraves do metodo findByCodigo
	 * e atraves do ModelAndView redireciona  
	 * Para Atualizar foi usado o metodo save de eventoRepository no metodo form desta classe
	 * 
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="seuContexto/{codigo}")
	public ModelAndView detalhesEventos(@PathVariable("codigo") Long codigo)
	{

		Evento evento = eventoRepository.findByCodigo(codigo);

		ModelAndView mv=new ModelAndView("evento/localizarFormEvento");

		
		mv.addObject("eventos",evento);
		return mv;


	}
	
	@RequestMapping(method=RequestMethod.GET,value="deleteEvento/{codigo}")
	public ModelAndView deletarEvento(@PathVariable("codigo") Long codigo)
	{
		
		
		
		ModelAndView mv=new ModelAndView("evento/listaeventos");
		eventoRepository.delete(codigo);

		return mv;

	}
	
	
	/**
	 *
	 * Relatorios JPA mapeamento de tabelas
	 * 
	 */



}
