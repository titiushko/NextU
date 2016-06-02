package Actividad03_03;

public class Main {
	public static void main(String[] args) {
		Lista lista = new Lista();
		
		System.out.print("Lista: \n");
		lista.insertar(20);
		lista.insertar(30);
		lista.insertar(40);
		lista.insertar(50);
		lista.insertar(60);
		lista.insertar(70);
		lista.insertar(80);
		lista.insertar(90);
		lista.mostrar();
		System.out.print("\n");

		System.out.print("Lista sin el nodo 30, 50, 70, 90: \n");
		lista.eliminar(30);
		lista.eliminar(50);
		lista.eliminar(70);
		lista.eliminar(90);

		lista.mostrar();
	}
}
