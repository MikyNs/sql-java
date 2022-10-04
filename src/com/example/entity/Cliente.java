package com.example.entity;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable{
	private static final long sarialVersionUID = 3L;
	
	private Integer IdCliente;
	private String nome;
	private String cognome;
	private String email;
	private String indirizzo;
	private String citta;
	private String provincia;
	private String cap;
	
	public Cliente(Integer IdCliente, String nome, String cognome, String email, String indirizzo, String citta,
			String provincia, String cap) {
		super();
		this.IdCliente = IdCliente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.cap = cap;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Integer IdCliente) {
		this.IdCliente = IdCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(cap, citta, cognome, email, IdCliente, indirizzo, nome, provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cap, other.cap) && Objects.equals(citta, other.citta)
				&& Objects.equals(cognome, other.cognome) && Objects.equals(email, other.email)
				&& Objects.equals(IdCliente, other.IdCliente) && Objects.equals(indirizzo, other.indirizzo)
				&& Objects.equals(nome, other.nome) && Objects.equals(provincia, other.provincia);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Clienti [idCliente=");
		builder.append(IdCliente);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cognome=");
		builder.append(cognome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", indirizzo=");
		builder.append(indirizzo);
		builder.append(", citta=");
		builder.append(citta);
		builder.append(", provincia=");
		builder.append(provincia);
		builder.append(", cap=");
		builder.append(cap);
		builder.append("]");
		return builder.toString();
	}
}