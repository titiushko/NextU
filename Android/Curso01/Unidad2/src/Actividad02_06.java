import java.util.Scanner;

public class Actividad02_06 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int numero1, numero2;
		System.out.println("N�mero 1:"); numero1 = teclado.nextInt();
		System.out.println("N�mero 2:"); numero2 = teclado.nextInt();
		
		if (numero1 > 10 && numero2 > 10) {
			System.out.println("N�mero 1 y n�mero 2 son mayores a 10.");
		}
		
		if (numero1 < 10 || numero2 < 10) {
			System.out.println("N�mero 1 o n�mero 2 es menor a 10.");
		}
		
		if (numero1 < 10 && numero2 < 10) {
			System.out.println("N�mero 1 y n�mero 2 son menores a 10.");
		}
		
		if (numero1 > 10 || numero2 > 10) {
			System.out.println("N�mero 1 o n�mero 2 es mayor a 10.");
		}
		
		if (numero1 != 10 && numero2 != 10) {
			System.out.println("N�mero 1 y n�mero 2 son distintos a 10.");
		}
		
		if (numero1 == 10 && numero2 == 10) {
			System.out.println("N�mero 1 y n�mero 2 son iguales a 10.");
		}
		
		teclado.close();
	}
}
