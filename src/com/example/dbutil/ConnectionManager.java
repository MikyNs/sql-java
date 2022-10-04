package com.example.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Crea una java.sql.Connection e la fornisce al richiedente
 * La classe costituisce un punto unico per l'applicazione dove cercare una connessione per il db.
 * La classe non può essere estesa.
 * La classe implementa il "Singleton" pattern https://it.wikipedia.org/wiki/Singleton_(informatica)
 */
public final class ConnectionManager {
	private static final Logger log = LogManager.getLogger(ConnectionManager.class);

	private static final String url = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";

	// Singleton
	private static ConnectionManager instance = null;

	// Singleton
	private ConnectionManager() {
		super();
	}

	// Singleton
	public static ConnectionManager getInstance() {
		if(instance == null) { // lazy init
			instance = new ConnectionManager();
		}
		return instance;
	}

	/**
	 * Crea la java.sql.Connection
	 *
	 * @return la java.sql.Connection generata
	 */
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			log.error("Errore di connessione al database ", e);
			throw new DatabaseConnectionException("Errore di connessione al database ", e);
		}
	}

}