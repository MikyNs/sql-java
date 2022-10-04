package com.example.jdbcdemo;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AutoCloseableDemo implements AutoCloseable {
	private static final Logger log = LogManager.getLogger(Demo02.class);

	@Override
	public void close() throws SQLException {
		log.info("close() chiamato su AutoCloseableDemo... ");
	}

}