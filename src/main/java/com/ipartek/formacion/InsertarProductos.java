package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.modelo.Producto;

public class InsertarProductos {

	public static void main(String[] args) {
		
		//credenciales de acceso a BBDD
		final String usuario = "debian-sys-maint";
		final String pass = "o8lAkaNtX91xMUcV";
		final String URL = "jdbc:mysql://localhost/supermercado";
		//Sentencias a ejecutar
		final String SQL = "INSERT INTO producto (nombre, id_usuario) VALUES (?, 1);";
		//Introducir datos por pantalla
		Scanner sc = new Scanner (System.in);
		String sc_nombre;
		String catch_nombre = "";
		int sc_idusuario;
		
		try {
			//TODO añadir clase ConnectionManager
			
			
			//Comprobación de que existe el JAR de mysql
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("El jar para mysql está operativo");
			
			//Conectar a la bbdd supermercado
			Connection conexion = DriverManager.getConnection(URL, usuario, pass);
			System.out.println("Conexión con éxito");
			
			//Preparar sentencia a ejecutar
			PreparedStatement prepconsulta = conexion.prepareStatement(SQL);
						
			System.out.println("INSERCIÓN DE PRODUCTOS");
			System.out.println("Introduce nombre del producto: ");
			sc_nombre = sc.nextLine();
			catch_nombre = sc_nombre;
			//Cambiar la sentencia SQL con los datos introducidos por pantalla
			prepconsulta.setString(1, sc_nombre);
			
			//Ejecutar la inserción contra la bbdd
			int filas = prepconsulta.executeUpdate(); //Este método nos devuelve un entero que es el número de filas de la tabla afectadas.
			//Informar del resultado de la inserción
			System.out.println("Han sido insertados " +filas + " registros con éxito");
			 
			
			
		}
		catch(Exception e) { //Capturamos "el padre de todas las excepciones"
			
			e.printStackTrace();
			System.out.println("El nombre "+ catch_nombre + " ya está en uso en la bbdd, prueba con otro nombre");
		}
		
				
	}

}
