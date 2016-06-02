package Actividad02_04;

import java.util.Random;
import java.util.Arrays;

public class BusquedaBinaria {
	private int[] valores;
	private static Random numeros_aleatorios = new Random();

	public BusquedaBinaria(int cantidad_elementos) {
		valores = new int[cantidad_elementos];

		for (int i = 0; i < cantidad_elementos; i++) {
			valores[i] = 10 + numeros_aleatorios.nextInt(90);
		}

		Arrays.sort(valores);
	}

	public int busquedaBinaria(int datoBusqueda) {
		int inicial = 0;
		int longitud = valores.length - 1;
		int mitad = (inicial + longitud + 1) / 2;
		int posicion = -1;

		do {
			System.out.print(restantes(inicial, longitud));

			for (int i = 0; i < mitad; i++) {
				System.out.print(" ");
			}
			System.out.println("^");

			if (datoBusqueda == valores[mitad]) {
				posicion = mitad;
			}
			else if (datoBusqueda < valores[mitad]) {
				longitud = mitad - 1;
			}
			else {
				inicial = mitad + 1;
			}

			mitad = (inicial + longitud + 1) / 2;
		} while ((inicial <= longitud) && (posicion == -1));

		return posicion;
	}

	public String restantes(int inicial, int longitud) {
		StringBuilder temporal = new StringBuilder();

		for (int i = 0; i < inicial; i++) {
			temporal.append(" ");
		}

		for (int i = inicial; i <= longitud; i++) {
			temporal.append(valores[i] + " ");
		}

		temporal.append("\n");
		return temporal.toString();
	}

	public String toString() {
		return restantes(0, valores.length - 1);
	}
}
