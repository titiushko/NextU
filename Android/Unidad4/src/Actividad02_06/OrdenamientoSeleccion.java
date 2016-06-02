package Actividad02_06;

import java.util.Random;

public class OrdenamientoSeleccion {
	private int[] valores;
	private static Random numeros_aleatorios = new Random();

	public OrdenamientoSeleccion(int cantidad_elementos) {
		valores = new int[cantidad_elementos];

		for (int i = 0; i < cantidad_elementos; i++) {
			valores[i] = 10 + numeros_aleatorios.nextInt(90);
		}
	}

	public void ordenar() {
		int menor;

		for (int i = 0; i < valores.length - 1; i++) {
			menor = i;

			for (int indice = i + 1; indice < valores.length; indice++) {
				if (valores[indice] < valores[menor]) {
					menor = indice;
				}	
			}

			intercambiarNumero(i, menor);
			imprimirIteracion(i + 1, menor);
		}
	}

	public void intercambiarNumero(int primero, int segundo) {
		int anterior = valores[primero];
		valores[primero] = valores[segundo];
		valores[segundo] = anterior;
	}

	public void imprimirIteracion(int iteracion, int indice) {
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
		StringBuilder anterior = new StringBuilder();

		for (int elemento : valores) {
			anterior.append(elemento + " ");
		}

		anterior.append("\n");
		return anterior.toString();
	}
}
