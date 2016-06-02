package Actividad03_05;

public class Pila {
	Nodo tope;

	public Pila() {
		tope = null;
	}
	
	private boolean vacia() {
		if (tope == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void agregar(int dato) {
		Nodo nuevo;
		nuevo = new Nodo();
		nuevo.valor = dato;

		if (vacia()) {
			nuevo.siguiente = null;
			tope = nuevo;
		}
		else {
			nuevo.siguiente = tope;
			tope = nuevo;
		}
	}

	public int eliminar() {
		if (!vacia()) {
			int dato = tope.valor;
			tope = tope.siguiente;
			return dato;
		}
		else {
			return Integer.MAX_VALUE;
		}
	}

	public void mostrar() {
		Nodo pila = tope;
		System.out.println("Los nodos de la pila son: ");
		
		while (pila != null) {
			System.out.print("|" + pila.valor + "|");
			pila = pila.siguiente;
		}
		
		System.out.println();
	}
}
