package com.example.jdbcdemo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.dbutil.ClientiXXX;
import com.example.dbutil.GenericDatabaseException;
import com.example.entity.Cliente;


/*
 * Copia utilizzabile come esempio di jdbc
 * versione try with resources
 * questa � demo07
 */

public class DemoClienti {

	private static final Logger log = LogManager.getLogger(DemoClienti.class);

	public static void main(String[] args) throws GenericDatabaseException {

		ClientiXXX xxx = new ClientiXXX();
		List<Cliente> clienti = xxx.findAll();
		clienti.forEach(c -> log.info("Trovato : {}", c));

	}

}
