import java.util.Scanner;

public class Actividad03_02 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int numero1, numero2, numero3;
		
		System.out.println("N�mero 1:"); numero1 = 10;//entrada.nextInt();
		System.out.println("N�mero 2:"); numero2 = 20;//entrada.nextInt();
		System.out.println("N�mero 3:"); numero3 = 5;//entrada.nextInt();
		
		System.out.println("\nRESULTADOS OPERADORES ARIMETICOS");
		System.out.printf("Sumando %d + %d + %d: %d\n", numero1, numero2, numero3, (numero1 + numero2 + numero3));
		System.out.printf("Restando %d - %d: %d\n", numero1, numero3, (numero1 - numero3));
		System.out.printf("Multiplicando %d * %d * %d: %d\n", numero1, numero2, numero3, (numero1 * numero2 * numero3));
		System.out.printf("Dividiendo %d / %d: %d\n", numero2, numero3, (numero2 / numero3));
		System.out.printf("Modulo %d y %d: %d\n", numero2, numero1, (numero2 % numero1));
		
		System.out.println("\nRESULTADOS OPERADORES LOGICOS");
		if (numero1 > numero2) {
			System.out.println("N�mero 1 es mayor a n�mero 2");
		}
		else {
			System.out.println("N�mero 1 es menor a n�mero 2");
		}
		if (numero2 == numero3) {
			System.out.println("N�mero 2 es igual a n�mero 3");
		}
		else {
			System.out.println("N�mero 2 es distinto a n�mero 3");
		}
		if (numero1 < numero3) {
			System.out.println("N�mero 1 es menor a n�mero 3");
		}
		else {
			System.out.println("N�mero 1 es mayor a n�mero 3");
		}
		
		entrada.close();
	}
}
