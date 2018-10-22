package com.estudo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

/**
 * @return
 * @RestController não funciona com o retorno apenas de String, só funcionou com @Controller
 * 
 * 
 */
	
	 
	 @RequestMapping(method=RequestMethod.GET,value="/")
		public String index() {
			return "index";
			
		}	
	 
	/**
	 * 	
	 * 
	 * Coloquei esse metodo para testar
	 * Funcionou...o redirecionamento
	 
	 
	 @RequestMapping("/foo")
	  void handleFoo(HttpServletResponse response) throws IOException {
	    response.sendRedirect("index");
	  }
	 */
}
