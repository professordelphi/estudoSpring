package com.estudo.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value="/")
	public String index() {
		return "index";
		
	}
	
	/**
	 * 
	 * 
	 * Coloquei esse metodo para testar
	 * Funcionou...o redirecionamento
	 * @param response
	 * @throws IOException
	 */
	 @RequestMapping("/foo")
	  void handleFoo(HttpServletResponse response) throws IOException {
	    response.sendRedirect("/");
	  }
	 
	 @RequestMapping(value="/chamartelacadastroevento") //Define a url que quando for requisitada chamara o metodo
	    public String chamartelacadastroevento(){
	      
	        return "evento/formevento";
	    }
}
