package com.estudo.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="patrocinio")
public class Patrocinio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	
	
	private String patrocinador;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Evento evento;
	
	
	public Patrocinio() {
		// TODO Auto-generated constructor stub
	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getPatrocinador() {
		return patrocinador;
	}


	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
	}


	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}



/**
 * VERIFICAR O FLYWAY
 * VERIFICAR O @JoinColumn se coloca no atributo ou no evento
 * 
 * @return
 */



	





	




	





	


	

}
