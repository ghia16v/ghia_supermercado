package com.ipartek.modelo;

import java.sql.*;

public class ConnectionManager {

	private final static String usuario = "debian-sys-maint";
	private final static String pass = "o8lAkaNtX91xMUcV";
	private final static String URL = "jdbc:mysql://localhost/supermercado";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection con = null;
		
		//Comprobación de que existe el JAR de mysql
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("El jar para mysql está operativo");
		
		con = DriverManager.getConnection(URL, usuario, pass);
		return con;
	}
}
