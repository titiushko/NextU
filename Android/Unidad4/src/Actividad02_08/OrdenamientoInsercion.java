package Actividad02_08;

import java.util.Random;

public class OrdenamientoInsercion {
	private int[] valores;
	private static Random numeros_aleatorios = new Random();

	public OrdenamientoInsercion(int cantidad_elementos) {
		valores = new int[cantidad_elementos];

		for (int i = 0; i < cantidad_elementos; i++) {
			valores[i] = 10 + numeros_aleatorios.nextInt(90);
		}
	}

	public void ordenar() {
		int insercion;

		for (int siguiente = 1; siguiente < valores.length; siguiente++) {
			insercion = valores[siguiente];

			int moverDato = siguiente;
			while (moverDato > 0 && valores[moverDato - 1] > insercion) {
				valores[moverDato] = valores[moverDato - 1];
				moverDato--;
			}

			valores[moverDato] = insercion;
			imprimirIteracion(siguiente, moverDato);
		}
	}

	public void imprimirIteracion(int iteracion, int indice) {
		System.out.print(String.format("", iteracion));

		for (int i = 0; i < indice; i++) {
			System.out.print(valores[i] + " ");
		}

		System.out.print(valores[indice] + "* ");
		for (int i = indice + 1; i < valores.length; i++) {
			System.out.print(valores[i] + " ");
		}

		System.out.println();

		for( int j = 0; j < iteracion; j++ ) {
			System.out.print(" ");
		}
		
		System.out.println(" ^");
	}

	public String toString() {
		StringBuilder temporal = new StringBuilder();

		for (int elemento : valores) {
			temporal.append(elemento + " ");
		}

		temporal.append("\n");
		return temporal.toString();
	}
}
