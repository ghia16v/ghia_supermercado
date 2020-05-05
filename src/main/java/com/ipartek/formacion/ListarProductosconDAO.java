package com.ipartek.formacion;

import java.util.ArrayList;
import com.ipartek.modelo.*;
public class ListarProductosconDAO {

	public static void main(String[] args) {
	ProductDAO dao = ProductDAO.getInstance(); //Recuperamos la instancia de producto
	
	ArrayList<Producto> productos = dao.getAll(); //Ejecutamos su método definido en la interfaz e implementado en el DAO.
	
	System.out.println("Resultado de LISTADO DE PRODUCTOS");
	System.out.println("");
	
	for (Producto p: productos) { //Estructura iterativa foreach, recorrerá todas las posiciones de la lista.
		System.out.println(p);
	}

}

}