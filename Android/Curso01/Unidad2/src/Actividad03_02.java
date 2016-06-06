import java.util.Scanner;

public class Actividad03_02 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		// 1
		System.out.println("EJERCICIO 1");
		int vector[] = new int[5];
		
		for (int i = 0; i < 5; i++) {
			System.out.printf("Número %d: ", (i + 1));
			vector[i] = teclado.nextInt();
		}
		
		System.out.printf("Vector[%d", vector[0]);
		for (int i = 1; i < vector.length; i++) {
			System.out.printf(", %d", vector[i]);
		}
		System.out.println("]");
		
		// 2
		System.out.println("\nEJERCICIO 2");
		String matriz[][] = new String[2][2];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print("Valor[" + i + "][" + j + "]: ");
				matriz[i][j] = teclado.nextLine();
			}
		}
		
		for (int i = 0; i < matriz.length; i++) {
			System.out.printf("%s, %s\n", matriz[i][0], matriz[i][1]);
		}
		
		teclado.close();
	}
}
