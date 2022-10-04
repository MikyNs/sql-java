package com.example.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.entity.Regione;

public class Demo02 {
	private static final Logger log = LogManager.getLogger(Demo01.class);

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mariadb://localhost:3306/corso?user=master&password=manager";
		Connection conn = DriverManager.getConnection(url);
		log.info("Connessione al database stabilita...");

		String query = "select id, nome, latitudine, longitudine from regioni order by nome";
		PreparedStatement pst = conn.prepareStatement(query);

		ResultSet rs = pst.executeQuery();

		while(rs.next()) {
			Regione r = new Regione();
			r.setId(rs.getInt("id"));
			r.setNome(rs.getString("nome"));
			r.setLatitudine(rs.getDouble("latitudine"));
			r.setLongitudine(rs.getDouble("longitudine"));
			log.info("Trovato {}", r);
		}

		rs.close();
		pst.close();
		conn.close();

	}

}
