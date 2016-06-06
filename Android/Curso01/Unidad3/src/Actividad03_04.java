import java.util.Scanner;

public class Actividad03_04 {
	public static long serieFibonacci(long n) {
		if (n == 0 || n == 1) {
			return n;
		}
		else {
			return serieFibonacci(n - 1) + serieFibonacci(n - 2);
		}
	}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		
		System.out.println("Digite un número para generar la serie: "); numero = teclado.nextInt();
		System.out.printf("Fibonacci de %d es = ", numero);
		for (int i = 0; i <= numero; i++)  System.out.printf("%d, ", serieFibonacci(i));

		teclado.close();
	}
}
