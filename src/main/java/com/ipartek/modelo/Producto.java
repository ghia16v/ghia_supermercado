/**
 * clase POJO de PRODUCTO. Esta clase encapsula la lógica de negocio.
 * Los controladores acceden a su lógica de negocio que a la vez interactuan
 * con el POJO para acceder a la bbdd.
 * El POJO tiene los mismos atributos que la entidad de la bbdd.
 * 
 * 
 */

package com.ipartek.modelo;

public class Producto {
	
	//Atributos encapsulados
	private int id;
	private String nombre;
	
	//Constructor
	public Producto () {
		super (); //Al instanciar lo primero se llama al constructor de superclase
		this.id = 0;
		this.nombre = "";
	}
	
	public Producto (String nombre) {
		this(); //Este constructor llamará primero al primer constructor
		this.nombre = nombre; // Guardaremos en la variable de instancia lo que nos llega por parámetro.
	}

	//Getter & Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Método toString()
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + "]";
	}


}
