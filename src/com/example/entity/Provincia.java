package com.example.entity;

import java.io.Serializable;
import java.util.Objects;

public class Provincia implements Serializable{
	private static final long sarialVersionUID = 2L;
	
	private Integer id;
	private Integer id_regione;
	private Integer codice_citta_metropolitana;
	private String nome;
	private String sigla_automobilistica;
	private double latitudine;
	private double longitudine;
	
	public Provincia(Integer id, Integer id_regione, Integer codice_citta_metropolitana, String nome,
			String sigla_automobilistica, double latitudine, double longitudine) {
		super();
		this.id = id;
		this.id_regione = id_regione;
		this.codice_citta_metropolitana = codice_citta_metropolitana;
		this.nome = nome;
		this.sigla_automobilistica = sigla_automobilistica;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}

	public Provincia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_regione() {
		return id_regione;
	}

	public void setId_regione(Integer id_regione) {
		this.id_regione = id_regione;
	}

	public Integer getCodice_citta_metropolitana() {
		return codice_citta_metropolitana;
	}

	public void setCodice_citta_metropolitana(Integer codice_citta_metropolitana) {
		this.codice_citta_metropolitana = codice_citta_metropolitana;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla_automobilistica() {
		return sigla_automobilistica;
	}

	public void setSigla_automobilistica(String sigla_automobilistica) {
		this.sigla_automobilistica = sigla_automobilistica;
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

	public static long getSarialversionuid() {
		return sarialVersionUID;
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
		Provincia other = (Provincia) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Provincia [id=");
		builder.append(id);
		builder.append(", id_regione=");
		builder.append(id_regione);
		builder.append(", codice_citta_metropolitana=");
		builder.append(codice_citta_metropolitana);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", sigla_automobilistica=");
		builder.append(sigla_automobilistica);
		builder.append(", latitudine=");
		builder.append(latitudine);
		builder.append(", longitudine=");
		builder.append(longitudine);
		builder.append("]");
		return builder.toString();
	}
}


