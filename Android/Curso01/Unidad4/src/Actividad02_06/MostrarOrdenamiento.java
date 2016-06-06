package Actividad02_06;

public class MostrarOrdenamiento {
	public static void main(String[] args) {
		OrdenamientoSeleccion arregloOrdenado = new OrdenamientoSeleccion(10);

		System.out.println("Arreglo Inicial:");
		System.out.println(arregloOrdenado);

		arregloOrdenado.ordenar();

		System.out.println("Arreglo Ordenado:");
		System.out.println(arregloOrdenado);
	}
}
