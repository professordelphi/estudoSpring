package com.estudo.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="evento_codigo")
	private Evento evento;
	
	
	@Embedded
	private Representante representante;
	
	
	public Patrocinio() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Patrocinio [codigo=" + codigo + ", patrocinador=" + patrocinador + ", evento=" + evento + "]";
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


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Patrocinio(Long codigo, String patrocinador, Evento evento) {
		super();
		this.codigo = codigo;
		this.patrocinador = patrocinador;
		this.evento = evento;
	}


	public Representante getRepresentante() {
		return representante;
	}


	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}


	

}
