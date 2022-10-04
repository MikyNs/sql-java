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

import com.example.dbutil.ConnectionManager;
import com.example.dbutil.GenericDatabaseException;
import com.example.entity.Regione;

/**
 * copia utilizzabile come esempio di utilizzo jdbc
 * versione try with resources (try prende in input oggetti istanze di classi AutoCloseable)
 */
public class Demo05 {
	private static final Logger log = LogManager.getLogger(Demo05.class);
	//private static String url = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";
	private static String query = "select id, nome, latitudine, longitudine from regioni order by nome";

	public static void main(String[] args) throws GenericDatabaseException {

		List<Regione> regioni = new ArrayList<>();

		try ( // spazio per le risorse AutoCloseable
				//Connection conn = DriverManager.getConnection(url);
				Connection conn = ConnectionManager.getInstance().getConnection();
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				) {
			log.debug("classe Connection {}", conn.getClass().getName());
			log.debug("classe PreparedStatement {}", pst.getClass().getName());
			log.debug("classe ResultSet {}", rs.getClass().getName());
			while (rs.next()) {
				Regione r = new Regione(rs.getInt("id"), rs.getString("nome"), rs.getDouble("latitudine"),
						rs.getDouble("longitudine"));
				regioni.add(r);
				log.trace("numero regioni {}", regioni.size());
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

		regioni.forEach(r -> log.info("Trovata {}", r));
	}

}
