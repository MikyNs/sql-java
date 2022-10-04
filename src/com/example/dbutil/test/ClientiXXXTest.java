package com.example.dbutil.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.example.dbutil.ClientiXXX;
import com.example.dbutil.ConnectionManager;
import com.example.entity.Cliente;

class ClientiXXXTest {
	private static final Logger log = LogManager.getLogger(ConnectionManager.class);

	@Test
	void test() {
		ClientiXXX xxx = new ClientiXXX();
		List<Cliente> clienti = xxx.findAll();
		assert(clienti.size() > 0);
		log.info("Trovati {} clienti", clienti.size());
	}
	
	@Test
	void test2() {
		ClientiXXX xxx = new ClientiXXX();
		Cliente cliente = xxx.findById(9); 
		log.info(cliente);
	}
	
	

}