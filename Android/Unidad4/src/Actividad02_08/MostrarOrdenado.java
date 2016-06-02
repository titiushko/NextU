package Actividad02_08;

public class MostrarOrdenado {
	public static void main(String[] args) {
		OrdenamientoInsercion arregloOrden = new OrdenamientoInsercion(10);

		System.out.println("Arreglo Inicial:");
		System.out.println(arregloOrden);

		arregloOrden.ordenar();

		System.out.println("Arreglo ordenado:");
		System.out.println(arregloOrden);
	}
}
