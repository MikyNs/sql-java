package com.example.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.dbutil.GenericDatabaseException;
import com.example.entity.Regione;

public class Demo04 {
	private static final Logger log = LogManager.getLogger(Demo01.class);
	private static String url = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";
	private static String query = "select id, nome, latitudine, longitudine from regioni order by nome";

	public static void main(String[] args) {

		Connection conn =null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Regione> regioni = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(url);
			log.info("Connessione al database stabilita...");
			pst = conn.prepareStatement(query);
			log.trace("PrepareStatement creato...");
			rs = pst.executeQuery();
			log.trace("Query eseguita...");
			while(rs.next()) {
				Regione r = new Regione(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getDouble("latitudine"),
						rs.getDouble("longitudine")
						);
				regioni.add(r);
				log.trace("numero regioni {}", regioni.size());
			}
		} catch (SQLException e) {
			log.error("Anomalia nell'elaborazione degli statement SQL", e);
			e.printStackTrace();
			// System.exit(1); // non usata perchè  unconditional abort della JVM
			// emettere una nostra eccezione
			String str = String.format("Corso Java: %s", e.getMessage());
			throw new GenericDatabaseException( str, e);
		} finally {
			log.trace("inizio blocco finally...");
			try { rs.close(); } catch (Exception e1) {}
			log.trace("ResultSet chiuso...");
			try { pst.close(); } catch (Exception e1) {}
			log.trace("PreparedStatement chiuso...");
			try { conn.close(); } catch (Exception e1) {}
			log.trace("Connection chiusa...");
			log.trace("fine blocco finally...");
		}

		regioni.forEach(r -> log.info("Trovato {}", r));
	}
}
