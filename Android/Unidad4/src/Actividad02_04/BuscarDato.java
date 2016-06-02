package Actividad02_04;

import java.util.Scanner;

public class BuscarDato {
	public static void main(String args[]) {
		Scanner teclado = new Scanner(System.in);
		int dato;
		int posicion;
		int longitud = 15;

		BusquedaBinaria arreglo = new BusquedaBinaria(longitud);
		System.out.println(arreglo);

		System.out.print("Escriba el numero que desea buscar: ");
		dato = teclado.nextInt();
		System.out.println();

		while (dato != -1) {
			posicion = arreglo.busquedaBinaria(dato);

			if (posicion == -1) {
				System.out.println("El entero " + dato + " no se encontro.\n");
			}	
			else {
				System.out.println("El entero " + dato + " se encontro en la posicion " + posicion + ".\n");
			}

			System.out.print("Buscar otro número o -1 para terminar: ");
			dato = teclado.nextInt();
			System.out.println();
		}
		
		System.out.print("Fin.");
		teclado.close();
	}
}
