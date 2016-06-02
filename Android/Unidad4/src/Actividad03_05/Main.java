package Actividad03_05;

public class Main {
	public static void main(String[] args) {
		Pila pila = new Pila();
		pila.agregar(10);
		pila.agregar(20);
		pila.agregar(30);
		pila.agregar(40);
		pila.agregar(50);
		pila.agregar(60);
		pila.mostrar();
		System.out.println("El nodo eliminado de la pila es: " + pila.eliminar());
		System.out.println("El nodo eliminado de la pila es: " + pila.eliminar());
		pila.mostrar();
	}
}
