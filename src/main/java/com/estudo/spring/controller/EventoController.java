package com.estudo.spring.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.estudo.spring.model.Evento;
import com.estudo.spring.repository.EventoRepository;


@RestController
public class EventoController {
	 private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EventoController.class);

	@Autowired
	private EventoRepository eventoRepository;
	/**
	 *  @return
	 *  
	 *  Apenas chama a tela de cadastro de evento - sem cadastrar
	 */
	@RequestMapping(method=RequestMethod.GET,value="/chamartelacadastroevento",produces=MediaType.APPLICATION_JSON_UTF8_VALUE) //Define a url que quando for requisitada chamara o metodo
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




	@RequestMapping(method=RequestMethod.GET,value="/listaev",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
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
	@RequestMapping(method=RequestMethod.GET,value="seuContexto/{codigo}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView detalhesEventos(@PathVariable("codigo") Long codigo)
	{

		Evento evento = eventoRepository.findByCodigo(codigo);

		ModelAndView mv=new ModelAndView("evento/localizarFormEvento");

		
		mv.addObject("eventos",evento);
		return mv;


	}
	
	@RequestMapping(method=RequestMethod.GET,value="deleteEvento/{codigo}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
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
          void save(PessoaModel pessoa);
 
 	  void delete(PessoaModel pessoa);
 
   	  List<PessoaModel> findAll();
 
          PessoaModel findOne(Integer id);
	 */

	/*
	 * 
	 * O metodo abaixo nao retornou o json e sim tela vazia pois o ModelAndView precisa de um objeto na camada visual 
	 * para mostrar o conteudo da consulta
	 */
	@RequestMapping(method=RequestMethod.GET,value="/listaevAPI/{nome}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Evento> listaEventosAPI(@PathVariable("nome") String nome)
	{

		
		List<Evento> eventos= eventoRepository.findByNome(nome);

		
		LOGGER.info("Lista de eventos "+ eventos.get(0).getData());
		
		
		LOGGER.info("Lista de eventos "+ eventos.toString());
	
	    return eventos;
	  }

	
	     @GetMapping("/tickets") //funcionou, retornou json
	
	    public List<Evento> getAllTickets() {
	
		
		List<Evento> resultado= (List<Evento>) eventoRepository.findAll();
		
		LOGGER.info("Lista de eventos "+ resultado.toString());
		
	        return resultado; 
	
	    }
	     
	     /*
	      * 
	      * Funcionaram os metodos listaEventosAPI2 e getAllTickets
	      */
	     @RequestMapping(method=RequestMethod.GET,value="/listaevAPI2",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	 	public List<Evento> listaEventosAPI2()
	 	{
 		
	 		List<Evento> eventos = (List<Evento>) eventoRepository.findAll();

	 	    return eventos;
 }

	     
	     
	     @RequestMapping(method=RequestMethod.GET,value="/listaevAPINomeAndData",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	 	public List<Evento> listaEventosAPI(@PathVariable("nome") String nome,@PathVariable("data") String data)
	 	{

	 		
	 		@SuppressWarnings("unchecked")
			List<Evento> eventos= (List<Evento>) eventoRepository.findByNomeAndData(nome, data);

	 		
	 		LOGGER.info("Lista de eventos "+ data);
	 		
	 		
	 		LOGGER.info("Lista de eventos "+ eventos.toString());
	 	
	 	    return eventos;
	 	  }
	     
	     
	     /**
	      * Coloquei o metodo createTicket para testar um cadastro e retorna um json
	      * funcionou, isso é importante para integrar com o Angular
	      * 
	      * @param evento
	      * @return
	      */
	                @RequestMapping(method=RequestMethod.POST,value="/tickets2")
	     	        public Evento createTicket(Evento evento) {
	     
	             Evento savedTicket = eventoRepository.save(evento);
	     
	             return savedTicket;
	     
	         }
	     
	     
	     /**
	      * 
	      * 
	      *  @PostMapping("/tickets")
27
    public Ticket createTicket(@RequestBody Ticket ticket) {
28
        Ticket savedTicket = ticketService.createTicket(ticket);
29
        return savedTicket;
30
    }
v
	      */
}


