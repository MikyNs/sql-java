package com.example.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo01 {
	private static final Logger log = LogManager.getLogger(Demo01.class);

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";
		Connection conn = DriverManager.getConnection(url);
		log.info("Connessione al database stabilita...");

		String query = "select id, nome, latitudine, longitudine from regioni order by nome";
		PreparedStatement pst = conn.prepareStatement(query);

		ResultSet rs = pst.executeQuery();

		while(rs.next()) {
			String str = String.format("%s Regione %s lat=%s lon=%s", 
					rs.getInt("id"), rs.getString("nome"), 
					rs.getString("latitudine"), rs.getString("longitudine"));
			log.info("Trovato {}", str);
		}

		rs.close();
		pst.close();
		conn.close();

	}

}
