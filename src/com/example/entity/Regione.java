package com.example.entity;

import java.io.Serializable;
import java.util.Objects;

public class Regione implements Serializable{
	private static final long sarialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private double latitudine;
	private double longitudine;
	
	public Regione(Integer id, String nome, double latitudine, double longitudine) {
		super();
		this.id = id;
		this.nome = nome;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	
	public Regione() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}
	public double getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regione other = (Regione) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Regione [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", latitudine=");
		builder.append(latitudine);
		builder.append(", longitudine=");
		builder.append(longitudine);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}



