package Actividad05_06;

import java.util.HashSet;
import java.util.Iterator;


public class ActividadConjuntos {
	public static void main(String[] args) {
        Articulo articulo1 = new Articulo("001", "Sueter Polo", 50000);
        Articulo articulo2 = new Articulo("002", "Gorra Nike", 20000);
        Articulo articulo3 = new Articulo("003", "Zapatillas Adidas", 40000);
        Articulo articulo4 = new Articulo("004", "Bermuda Tommy", 3000);

        HashSet<Articulo> articulos = new HashSet<Articulo>();
        articulos.add(articulo1);
        articulos.add(articulo2);
        articulos.add(articulo3);
        articulos.add(articulo4);

        for(Iterator<Articulo> elementos = articulos.iterator(); elementos.hasNext();) { 
        	Articulo articulo = elementos.next();
	    	System.out.println(articulo.getNombre() + " - $" + articulo.getPrecio());
        }		
	}
}
