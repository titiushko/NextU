import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Actividad05_08 {
	public static void main(String[] args) {
		Map<Integer, String> empleados = new HashMap<Integer, String>();

		empleados.put(1234, "Juan Perez");
		empleados.put(5466, "Maria Gomez");
		empleados.put(9900, "Luis Paez");
		empleados.put(7886, "Pedro Romero");
		empleados.put(7886, "Carmen Montoya");

		System.out.println("LISTA DE EMPLEADOS:");
		Iterator<Integer> ite = empleados.keySet().iterator();
		while(ite.hasNext()) {
			Integer key = ite.next();
			System.out.println("Código: " + key + " --- Nombre: " + empleados.get(key));
		}
	}
}
