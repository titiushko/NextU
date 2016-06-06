import java.util.Scanner;

public class Actividad03_06 {
	public static int factorial(int n) {
		if (n > 0) {
			System.out.printf("%d x ", n);
			return n * factorial(n - 1);
		}
		else {
			System.out.printf("1 = ");
			return 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		
		System.out.println("Número: "); numero = teclado.nextInt();
		System.out.printf("El factorial de %d! es = ", numero);
		System.out.println(factorial(numero));
		
		teclado.close();
	}
}
