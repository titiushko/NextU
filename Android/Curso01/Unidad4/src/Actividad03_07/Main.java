package Actividad03_07;

public class Main {
	public static void main(String[] ar) {
		Cola cola = new Cola();
		cola.insertar(100);
		cola.insertar(200);
		cola.insertar(300);
		cola.insertar(400);
		cola.insertar(500);
		cola.mostrar();
		System.out.println("El nodo eliminado de la Cola es: " + cola.eliminar());
		System.out.println("El nodo eliminado de la Cola es: " + cola.eliminar());
		System.out.println("El nodo eliminado de la Cola es: " + cola.eliminar());
		cola.mostrar();
	}
}
