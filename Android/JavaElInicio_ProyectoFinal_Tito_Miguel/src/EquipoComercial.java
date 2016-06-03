import java.util.Scanner;

import entidades.Actividad;
import entidades.Negocio;
import entidades.Organizacion;
import entidades.Persona;
import herramientas.Validar;

/**
* @author titiushko
*/
public class EquipoComercial {
	public Persona[] personas;
	public Organizacion[] organizaciones;
	public Negocio[] negocios;
	public Actividad[] actividades;
	
	public EquipoComercial(int cantidadElementos) {
		personas = new Persona[cantidadElementos];
		organizaciones = new Organizacion[cantidadElementos];
		negocios = new Negocio[cantidadElementos];
		actividades = new Actividad[cantidadElementos];
	}
	
	/**
	* Registrar una entidad
	* @param entidad Entidad a registrar
	* @return Devuelve falso si hay alg�n error, de lo contrario devuelve verdadero
	*/
	public boolean registrar(String entidad) {
		try {
			switch (entidad) {
				case "personas":
					registrarPersona();
					break;
				case "organizaciones":
					
					break;
				case "negocios":
					
					break;
				case "actividades":
					
					break;
			}
			return true;
		}
		catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			return false;
		}
	}
	
	/**
	* Registrar una persona
	 * @throws Exception 
	*/
	public void registrarPersona() throws Exception {
		Scanner teclado = new Scanner(System.in);
		int indice = indiceDisponiblePersonas();
		if (indice == -1) {
			throw new Exception("No se pueden registrar m�s personas.");
		}
		
		try {
			System.out.printf("Agregando persona %d.\n", indice + 1);
			personas[indice] = new Persona();
			
			personas[indice].setCodigo(indice + 1);
			System.out.print("Nombre: "); personas[indice].setNombre(teclado.nextLine());
			System.out.print("Tel�fono: "); personas[indice].setTelefono(teclado.nextLine());
			String correoElectronico;
			do {
				System.out.print("Correo electr�nico (user@dominio.com): ");
				correoElectronico = teclado.nextLine();
				
			} while(!Validar.correoElectronico(correoElectronico));
			personas[indice].setCorreoElectronico(correoElectronico);
		}
		catch (Exception e) {
			personas[indice] = null;
			throw e;
		}
		finally {
			//teclado.close();
		}
	}
	
	/**
	* Obtener el indice de la primera posici�n disponible del array de personas
	* @return Devuelve el indice si encuentra una posici�n disponible, de lo contrario devuelve -1
	*/
	private int indiceDisponiblePersonas() {
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	* Valida si una entidad tiene espacio disponible para registrar
	* @param entidad Entidad a validar si tiene espacio disponible
	* @return Devuelve falso si no hay espacio disponible para registrar, de lo contrario devuelve verdadero
	*/
	public boolean espacioDisponible(String entidad) {
		boolean resultado = false;
		
		switch (entidad) {
			case "personas":
				resultado = espacioDisponiblePersonas();
				break;
			case "organizaciones":
				resultado = espacioDisponibleOrganizaciones();
				break;
			case "negocios":
				resultado = espacioDisponibleNegocios();
				break;
			case "actividades":
				resultado = espacioDisponibleActividades();
				break;
		}
		
		return resultado;
	}
	
	/**
	* Valida si hay espacio disponible para registrar personas
	* @return Devuelve falso si no hay espacio disponible para registrar mas personas, de lo contrario devuelve verdadero
	*/
	public boolean espacioDisponiblePersonas() {
		boolean resultado;
		int posicionesOcupadas = 0;
		
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] != null) {
				posicionesOcupadas++;
			}
		}
		
		if (posicionesOcupadas == personas.length) {
			resultado = false;
		}
		else {
			resultado = true;
		}
		
		return resultado;
	}
	
	/**
	* Valida si hay espacio disponible para registrar organizaciones
	* @return Devuelve falso si no hay espacio disponible para registrar mas organizaciones, de lo contrario devuelve verdadero
	*/
	public boolean espacioDisponibleOrganizaciones() {
		boolean resultado;
		int posicionesOcupadas = 0;
		
		for (int i = 0; i < organizaciones.length; i++) {
			if (organizaciones[i] != null) {
				posicionesOcupadas++;
			}
		}
		
		if (posicionesOcupadas == organizaciones.length) {
			resultado = false;
		}
		else {
			resultado = true;
		}
		
		return resultado;
	}
	
	/**
	* Valida si hay espacio disponible para registrar negocios
	* @return Devuelve falso si no hay espacio disponible para registrar mas negocios, de lo contrario devuelve verdadero
	*/
	public boolean espacioDisponibleNegocios() {
		boolean resultado;
		int posicionesOcupadas = 0;
		
		for (int i = 0; i < negocios.length; i++) {
			if (negocios[i] != null) {
				posicionesOcupadas++;
			}
		}
		
		if (posicionesOcupadas == negocios.length) {
			resultado = false;
		}
		else {
			resultado = true;
		}
		
		return resultado;
	}
	
	/**
	* Valida si hay espacio disponible para registrar actividades
	* @return Devuelve falso si no hay espacio disponible para registrar mas actividades, de lo contrario devuelve verdadero
	*/
	public boolean espacioDisponibleActividades() {
		boolean resultado;
		int posicionesOcupadas = 0;
		
		for (int i = 0; i < actividades.length; i++) {
			if (actividades[i] != null) {
				posicionesOcupadas++;
			}
		}
		
		if (posicionesOcupadas == actividades.length) {
			resultado = false;
		}
		else {
			resultado = true;
		}
		
		return resultado;
	}

	public String toString() {
		StringBuilder resultado = new StringBuilder();
		
		resultado.append("\nLISTADO DE PERSONAS\n");
		for (Persona persona : personas) {
			resultado.append("----------------------------------------------------------\n");
			
			if (persona != null) {
				resultado.append("C�digo: " + persona.getCodigo() + "\n");
				resultado.append("Nombre: " + persona.getNombre() + "\n");
				resultado.append("Tel�fono: " + persona.getTelefono() + "\n");
				resultado.append("Correo electr�nico: " + persona.getCorreoElectronico() + "\n");	
			}
			else {
				resultado.append("NULL\n");
			}
		}
		
		return resultado.toString();
	}
}
