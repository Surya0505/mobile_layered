package com.cg.mps.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.mps.exceptions.MPSException;

public class JDBCUtility {

	private static Connection connection = null;

	public static Connection getConnection() throws MPSException {

		File file = null;
		FileInputStream inputStream = null;

		file = new File("resources/jdbc.properties");
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			throw new MPSException("file not found");
		}

		Properties properties = new Properties();
		try {
			properties.load(inputStream);

			String driver = properties.getProperty("db.driver");
			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");

			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);

		} catch (IOException e1) {
			throw new MPSException("unable to load the file");
		} catch (ClassNotFoundException e) {
			throw new MPSException("class not loaded..");
		} catch (SQLException e) {
			throw new MPSException("not connected..");
		}

		return connection;
	}

}
