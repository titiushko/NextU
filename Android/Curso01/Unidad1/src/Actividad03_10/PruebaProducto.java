package Actividad03_10;

import Actividad03_04.Producto;

import java.io.PrintStream;
import java.util.Scanner;;

public class PruebaProducto {
	public static void main(String[] args) {
		Producto producto = new Producto();
		Scanner teclado = new Scanner(System.in);
		PrintStream consola = System.out;
		
		consola.println("Capturando Datos Producto");
		consola.printf("Codigo: "); producto.setCodigo(Integer.parseInt(teclado.nextLine()));
		consola.printf("Nombre: "); producto.setNombre(teclado.nextLine());
		consola.printf("Descripcion: "); producto.setDescripcion(teclado.nextLine());
		consola.printf("Valor: "); producto.setValor(Double.parseDouble(teclado.nextLine()));
		consola.printf("Cantidad: "); producto.setCantidad(Integer.parseInt(teclado.nextLine()));
		teclado.close();
		
		consola.println("\nMostrando Datos Producto");
		consola.println("Codigo: " + producto.getCodigo());
		consola.println("Nombre: " + producto.getNombre());
		consola.println("Descripcion: " + producto.getDescripcion());
		consola.println("Valor: " + producto.getValor());
		consola.println("Cantidad: " + producto.getCantidad());
	}
}
