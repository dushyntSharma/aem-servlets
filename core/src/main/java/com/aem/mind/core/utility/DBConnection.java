package com.aem.mind.core.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	private static Logger logger = Logger.getLogger("DBConnection");
	private static String JDBCURL = "jdbc:mysql://127.0.0.1:3306/aemjdbc";
	private static String USERNAME = "root";
	private static String PASS = "9909";

	public static Connection getConnection() {
		Connection con = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				logger.log(Level.WARNING, "Exception :: ", e);
			}
			con = DriverManager.getConnection(JDBCURL, USERNAME, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Exception :: ", e);
		}
		return con;
	}

}
