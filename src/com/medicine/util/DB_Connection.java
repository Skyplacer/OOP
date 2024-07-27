package com.medicine.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection extends CommonUtil{
	
	// Private constructor to prevent direct instantiation.
	private static Connection connection;
	
	private DB_Connection() {
		
	}
	
	/**
	 * Get a database connection using the properties defined in CommonUtil.
	 * 
	 * @return A database connection.
	 * @throws ClassNotFoundException if the specified database driver class is not found.
	 * @throws SQLException if a database access error occurs.
	 */
	
	public static Connection getDB_Connection() throws ClassNotFoundException, SQLException{
		
		// Check if the connection is null or closed
		if(connection == null || connection.isClosed()) {
			
			// Load the database driver class.
			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			
			// Create a database connection using the specified properties.
			connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
			
			
		}
		
		return connection;
	}

}
