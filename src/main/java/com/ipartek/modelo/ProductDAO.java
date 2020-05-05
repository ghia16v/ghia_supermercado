/**
 * DAO. Patrón arquitectónico que permite separar la lógica de acceso a datos (lógica para conexión con bbdd)
 *  de los objetos de negocio. De esta manera esta clase ENCAPSULA toda la lógica de la capa de acceso a datos
 *  al resto de la aplicación.
 *  ENLACE A GITHUB: https://github.com/ghia16v/ghia_supermercado.git
 */

package com.ipartek.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class ProductDAO implements CrudAble <Producto>{
	//Zona de variables de instancia
	private final String SQL_GET_ALL = "SELECT id, nombre FROM producto ORDER BY id ASC";
	private final String SQL_INSERT = "INSERT INTO producto (nombre, id_usuario) VALUES (?, 1);";
	
	//Patrón de diseño SINGLETON
	private static ProductDAO INSTANCE = null;
	
	private ProductDAO() { // constructor privado. No se puede instanciar esta clase desde otra clase.
		super();		
	}
	
	public synchronized static ProductDAO getInstance() { //Si la instancia no está creada la crearemos desde aquí que sí tenemos acceso
		if (INSTANCE == null) { //Se controla el acceso concurrente.
			INSTANCE = new ProductDAO();
		}
		return INSTANCE;  //Si el objeto ya está creado, en este caso se devolverá. De esta forma conseguimos tener un ÚNICO OBJETO.
	}


	@Override
	public ArrayList<Producto> getAll() {
		ArrayList <Producto> registros = new ArrayList<Producto>();
		
try { //bloque try/catch with resources. Estos recursos se cerrarán automáticamente gracias al bloque TRY/CATCH with resources.
			
			//Conectar a la bbdd supermercado
			Connection conexion = ConnectionManager.getConnection();
			System.out.println("Conexión con éxito");
			
			//EJECUTAR CONSULTA CONTRA LA BB.DD
			PreparedStatement prepconsulta = conexion.prepareStatement(SQL_GET_ALL);
			ResultSet resultconsulta = prepconsulta.executeQuery(SQL_GET_ALL);


			//TRATAR RESULTADOS PARA MOSTRAR EN CONSOLA
			while (resultconsulta.next() ) 	
			{
				int id = resultconsulta.getInt("id"); //este método devuelve el valor (de tipo entero) de la columna cuyo nombre sea "id"
				String nombre = resultconsulta.getString("nombre");
				
				//Uso de POJO
				Producto p = new Producto(nombre);
				p.setId(id); //Este constructor llama al constructor padre que ponía el id a 0, por lo que cambiamos su valor al valor que nos llega del resultSet
			
				//guardar producto en ArrayList
				registros.add(p);
			}

} catch(Exception e) {
	e.printStackTrace();
}
			
		
		return registros;
	}

	@Override
	public Producto getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto insert(Producto pojo) throws Exception {
		try {
			Connection conexion = ConnectionManager.getConnection();
			PreparedStatement pst = conexion.prepareStatement(SQL_INSERT);
			pst.setString(1, pojo.getNombre());
			int filas = pst.executeUpdate();
			
			if (filas ==1) {
				
				System.out.println("Producto guardado");
				System.out.println("Se ha guardado el producto con id " +pojo.getId()); //no se consigue el id porque en el momento de la instancia es 0.
				//TODO conseguir el ID correcto.
			}
			else {
				throw new Exception("No se pudo insertar el registro");
			}
		} catch(Exception e) {
			
		}
		
		return pojo;
	}

	@Override
	public Producto update(Producto pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	} //Aquí intercambiamos la clase genérica

}
