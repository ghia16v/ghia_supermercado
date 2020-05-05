package com.ipartek.formacion;
import java.util.Scanner;

import com.ipartek.modelo.ProductDAO;
import com.ipartek.modelo.Producto;

public class InsertarProductoConDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
boolean continuar = true;
ProductDAO dao = ProductDAO.getInstance();

try {
	Scanner sc = new Scanner(System.in);
	
	do {
		try {
		System.out.println("Nombre del producto");
		String nombre = sc.nextLine();
	
		Producto producto = new Producto();
		producto.setNombre(nombre);
		dao.insert(producto);
		
		continuar = false;
		}catch(Exception e) {
			System.out.println("El nombre ya existe");
		}
		

	
	}while(continuar);
	}catch(Exception e) {
		System.out.println("Problema en BBDD");
	}

}
}
