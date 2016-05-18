import java.util.Scanner;

public class Actividad02_02 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		// 1
		System.out.println("EJERCICIO 1");
		double estatura;
		System.out.println("Estatura de la persona en metros:"); estatura = Double.parseDouble(teclado.nextLine());
		
		if (estatura >= 2.0) {
			System.out.println("La persona puede jugar basketball.");
		}
		else {
			System.out.println("La persona no puede jugar basketball.");
		}
		
		// 2
		System.out.println("\nEJERCICIO 2");
		int edad;
		System.out.println("Edad de la persona:"); edad = Integer.parseInt(teclado.nextLine());
		
		if (edad >= 18) {
			System.out.println("La persona es mayor de edad.");
		}
		else {
			System.out.println("La persona es menor de edad.");
		}
		
		// 3
		System.out.println("\nEJERCICIO 3");
		int numero1, numero2, numero3;
		System.out.println("N�mero 1:"); numero1 = teclado.nextInt();
		System.out.println("N�mero 2:"); numero2 = teclado.nextInt();
		System.out.println("N�mero 3:"); numero3 = teclado.nextInt();
		
		if (numero1 > numero2) {
			if (numero1 > numero3) {
				System.out.println("N�mero 1 es mayor a n�mero 2 y mayor a n�mero 3");
			}
			else {
				System.out.println("N�mero 1 es mayor a n�mero 2 y menor a n�mero 3");
			}
		}
		else if (numero2 > numero3) {
			System.out.println("N�mero 2 es mayor a n�mero 1 y mayor a n�mero 3");
		}
		else {
			System.out.println("N�mero 3 es mayor a n�mero 1 y menor a n�mero 2");
		}
		
		// 4
		System.out.println("\nEJERCICIO 4");
		System.out.println("N�mero 1:"); numero1 = teclado.nextInt();
		System.out.println("N�mero 2:"); numero2 = teclado.nextInt();
		
		System.out.println("\nIncremento de n�mero 1:");
		while (numero1 != numero2) {
			if (numero1 <= numero2) {
				System.out.println(numero1);
				numero1++;
			}
		}
		
		System.out.println("\nDecremento de n�mero 2:");
		do {
			System.out.println(numero2);
			numero2--;
		} while (numero2 != 0);
		
		// 5
		System.out.println("\nEJERCICIO 5");
		System.out.println("N�mero:"); numero1 = teclado.nextInt();
		int sumando = 10, restando = 10, multiplicando = 10, dividiendo = 10, modulo = 10;
		sumando += numero1;
		restando -= numero1;
		multiplicando *= numero1;
		dividiendo /= numero1;
		modulo %= numero1;
		System.out.println("Sumando: " + sumando);
		System.out.println("Restando: " + restando);
		System.out.println("Multiplicando: " + multiplicando);
		System.out.println("Dividiendo: " + dividiendo);
		System.out.println("Modulo: " + modulo);
		
		teclado.close();
	}
}
