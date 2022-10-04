package com.example.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.entity.Regione;

public class Demo03 {
	private static final Logger log = LogManager.getLogger(Demo01.class);

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";
		Connection conn = DriverManager.getConnection(url);
		log.info("Connessione al database stabilita...");

		String query = "select id, nome, latitudine, longitudine from regioni order by nome";
		PreparedStatement pst = conn.prepareStatement(query);

		ResultSet rs = pst.executeQuery();
		
		List<Regione> regioni = new ArrayList<>();
		
		while(rs.next()) {
			Regione r = new Regione(
					rs.getInt("id"),
					rs.getString("nome"),
					rs.getDouble("latitudine"),
					rs.getDouble("longitudine")
					);
			regioni.add(r);
		}

		rs.close();
		pst.close();
		conn.close();
		
		regioni.forEach(r -> log.info("Trovato {}", r));
	}
}
