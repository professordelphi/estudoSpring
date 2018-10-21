package com.estudo.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {



	
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
	
	 
	 @RequestMapping(method=RequestMethod.GET,value="/")
		public String index() {
			return "index";
			
		}	
	 
	
}
