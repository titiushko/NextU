import java.util.Iterator;
import java.util.LinkedList;

public class Actividad05_04 {
	public static void main(String[] args) {
		LinkedList<String> animales = new LinkedList<String>();
		
		animales.add("Oso");
		animales.add("Tiburon");
		animales.add("Camello");
		animales.add("Perro");
		animales.add("Aguila");
		
		Iterator<String> animal = animales.iterator();

		System.out.println("LISTA DE ANIMALES:");
		while (animal.hasNext()) {
			System.out.println(animal.next());
		}
	}
}
