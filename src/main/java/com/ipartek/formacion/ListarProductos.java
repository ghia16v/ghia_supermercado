package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.modelo.ConnectionManager;
import com.ipartek.modelo.Producto;

public class ListarProductos {

	public static void main(String[] args) {
		
		//credenciales de acceso a BBDD
		final String usuario = "debian-sys-maint";
		final String pass = "o8lAkaNtX91xMUcV";
		final String URL = "jdbc:mysql://localhost/supermercado";
		//Sentencias a ejecutar
		final String SQL = "SELECT id, nombre FROM producto ORDER BY id ASC";
		
		Connection conexion = null;
		
		try {
			
			//Conectar a la bbdd supermercado
			conexion = ConnectionManager.getConnection();
			System.out.println("Conexión con éxito");
			
			//EJECUTAR CONSULTA CONTRA LA BB.DD
			PreparedStatement prepconsulta = conexion.prepareStatement(SQL);
			ResultSet resultconsulta = prepconsulta.executeQuery(SQL);
			
			//TRATAR RESULTADOS PARA MOSTRAR EN CONSOLA
			while (resultconsulta.next() ) 	
			{
				int id = resultconsulta.getInt("id"); //este método devuelve el valor (de tipo entero) de la columna cuyo nombre sea "id"
				String nombre = resultconsulta.getString("nombre");
				
				//Uso de POJO
				Producto p = new Producto(nombre);
				p.setId(id); //Este constructor llama al constructor padre que ponía el id a 0, por lo que cambiamos su valor al valor que nos llega del resultSet
				
				//Mostrar en consola
				System.out.println("ID de producto: " + p.getId());
				System.out.println("Nombre: " + p.getNombre());
				System.out.println("");
				
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("No es posible conectarse a la BBDD");
		}
		
				
	}

}
