import java.util.Scanner;

public class Actividad02_04 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		// 1
		System.out.println("EJERCICIO 1");
		int numero, suma = 0;
		String salida;
		System.out.println("N�mero:"); numero = teclado.nextInt();
		salida = Integer.toString(numero);
		
		for (int i = numero; i >= 0; i--) {
			suma += i;
			if (i < numero) {
				salida += " + " + i;
			}
		}
		
		System.out.println("Resultado: " + salida + " = " + suma);
		
		// 2
		System.out.println("\nEJERCICIO 2");
		int numero1, numero2;
		System.out.println("N�mero 1:"); numero1 = teclado.nextInt();
		System.out.println("N�mero 2:"); numero2 = teclado.nextInt();
		
		System.out.println("\nIncremento de n�mero 1:");
		while (numero1 != numero2) {
			if (numero1 <= numero2) {
				System.out.println(numero1);
				numero1++;
			}
			else {
				numero1 = numero2;
			}
		}
		
		System.out.println("\nDecremento de n�mero 2:");
		do {
			System.out.println(numero2);
			numero2--;
		} while (numero2 != 0);
		
		// 3
		System.out.println("\nEJERCICIO 3");
		int operador;
		double resultado = 0;
		System.out.println("N�mero 1:"); numero1 = teclado.nextInt();
		System.out.println("N�mero 2:"); numero2 = teclado.nextInt();
		
		System.out.println("Operaci�n:\n1)Sumar\n2)Restar\n3)Multiplicar\n4)Dividir\n");
		operador = teclado.nextInt();
		
		switch (operador) {
		case 1:
			resultado = numero1 + numero2;
			break;
		case 2:
			resultado = numero1 - numero2;
			break;
		case 3:
			resultado = numero1 * numero2;
			break;
		case 4:
			resultado = numero1 / numero2;
			break;
		}
		
		System.out.println("Resultado: " + resultado);
		
		teclado.close();
	}
}
