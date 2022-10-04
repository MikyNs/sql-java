package com.example.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.entity.Cliente;
import com.example.entity.Regione;

public class ClientiXXX {
	private static final Logger log = LogManager.getLogger(ClientiXXX.class);
	private static String findAllQuery = "SELECT id_cliente, nome, cognome, email, indirizzo, citta, provincia, cap FROM clienti";
	private static String findByIdQuery = "SELECT id_cliente, nome, cognome, email, indirizzo, citta, provincia, cap FROM clienti where id_cliente = ?";

	private Cliente buildCliente(ResultSet rs) throws SQLException {
		Cliente cliente = null;
		cliente = new Cliente();
		cliente.setIdCliente(rs.getInt("id_cliente"));
		cliente.setIdCliente(rs.getInt("id_cliente"));
		cliente.setNome(rs.getString("nome"));
		cliente.setCognome(rs.getString("cognome"));
		cliente.setEmail(rs.getString("email"));
		cliente.setIndirizzo(rs.getString("indirizzo"));
		cliente.setCitta(rs.getString("citta"));
		cliente.setProvincia(rs.getString("provincia"));
		cliente.setCap(rs.getString("cap"));
		return cliente;
	}
	
	public Cliente findById(Integer id) {
		Cliente cliente = null;

		try (
				Connection conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement pst = conn.prepareStatement(findByIdQuery); 
			) {
			pst.setInt(1, id); // setta il valore del parametro di ricerca
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				if (cliente == null) {
					cliente = buildCliente(rs);
				}
			}
		} catch (SQLException e) {
			log.error("Anomalia elaborazioni dati...");
			e.printStackTrace();
			String str = String.format("Corso Java: %s", e.getMessage());
			throw new GenericDatabaseException(str, e);
		}

		return cliente;
	}

	public List<Cliente> findAll() {
		List<Cliente> clienti = new ArrayList<>();
		try (Connection conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement pst = conn.prepareStatement(findAllQuery);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				clienti.add(buildCliente(rs));
			}

		} catch (SQLException e) {
			log.error("Anomalia elaborazioni dati...");
			e.printStackTrace();
			String str = String.format("Corso Java: %s", e.getMessage());
			throw new GenericDatabaseException(str, e);
		}
		return clienti;
	}
}