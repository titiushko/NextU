import java.util.Arrays;

public class Actividad05_02 {
	public static void main(String[] args) {
		double notas[] = {3.2, 4.5, 2.4, 5.0, 1.5, 3.7, 4.4, 2.9};
		
		System.out.println("Notas desordenadas:");
        mostrarNotas(notas);
		
        Arrays.sort(notas);
        System.out.println("Notas ordenadas:");
        mostrarNotas(notas);
	}
	
	public static void mostrarNotas(double vector[]) {
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]);
		}
	}
}