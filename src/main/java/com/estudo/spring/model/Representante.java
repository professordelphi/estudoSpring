package com.estudo.spring.model;

import javax.persistence.Embeddable;

@Embeddable
public class Representante {
	
	

	private String nome;   //nome da pessoa que representa o patrocinio
	
	

	public Representante() {
		// TODO Auto-generated constructor stub
	}



	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	



	

	

}
