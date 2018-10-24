package com.estudo.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;




@SuppressWarnings("serial")
@Entity
@NamedQueries({
@NamedQuery(name = "Evento.findByNome",query = "SELECT e FROM Evento e WHERE e.nome =:nome "),
@NamedQuery(name = "Evento.findByNomeAndData",query = "SELECT e FROM Evento e WHERE e.nome =:nome and e.data=:data")} )
public class Evento implements Serializable {
	
	
	
	
	@SuppressWarnings("unused")
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	private String nome;
	private String local;
	
	private String data;
	
	private String horario;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getData() {
		return data;
	}
	

	public void setData(String data) {
		this.data = data;
	}
	
	
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	@Override
	public String toString() {
		return "Evento [codigo=" + codigo + ", nome=" + nome + ", local=" + local + ", data=" + data + ", horario="
				+ horario + "]";
	}
	

}
