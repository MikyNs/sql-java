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
import com.example.entity.Provincia;

/**
 * copia utilizzabile come esempio di utilizzo jdbc versione try with resources
 */
public class Demo06 {
	private static final Logger log = LogManager.getLogger(Demo06.class);
	private static String url = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";
	private static String query = "select id, id_regione, codice_citta_metropolitana, nome, sigla_automobilistica, latitudine, longitudine from province order by nome";

	public static void main(String[] args) throws GenericDatabaseException {

		List<Provincia> provincie = new ArrayList<>();

		try ( // spazio per le risorse AutoCloseable
				Connection conn = DriverManager.getConnection(url);
				PreparedStatement pst = conn.prepareStatement(query);
				AutoCloseableDemo acd = new AutoCloseableDemo();
				ResultSet rs = pst.executeQuery();
				) {
			while (rs.next()) { 
				Provincia p = new Provincia(
						rs.getInt("id"), 
						rs.getInt("id_regione"), 
						rs.getInt("codice_citta_metropolitana"), 
						rs.getString("nome"), 
						rs.getString("sigla_automobilistica"),
						rs.getDouble("latitudine"),
						rs.getDouble("longitudine")
						);
				provincie.add(p);
				log.trace("numero regioni {}", provincie.size());
			}
		} catch (SQLException e) {
			log.error("Anomalia nell'elaborazione degli statement SQL", e);
			e.printStackTrace();
			// System.exit(1); // non usata perchè unconditional abort della JVM
			// emettere una nostra eccezione
			String str = String.format("Corso Java: %s", e.getMessage());
			throw new GenericDatabaseException(str, e);
		} finally {
			log.trace("inizio blocco finally...");
			log.trace("fine blocco finally...");
		}

		provincie.forEach(r -> log.info("Trovata {}", r));
	}

}