import java.util.Scanner;

public class Actividad03_02 {
	public static int sumaNumeros(int n) {
		if (n == 1) {
			System.out.printf("%d = ", n);
			return n;
		}
		else {
			System.out.printf("%d + ", n);
			return n + sumaNumeros(n - 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		
		System.out.println("N�mero: "); numero = teclado.nextInt();
		System.out.printf("La suma de 1 hasta %d es = ", numero);
		System.out.println(sumaNumeros(numero));
		
		teclado.close();
	}
}
