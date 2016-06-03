import java.text.SimpleDateFormat;
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
	
	/**
	* Inicializar la cantidad de elementos que se puedan registrar de las entidades
	* @param cantidadElementos Cantidad de registros que se podrán almacenar de las entidades 
	*/
	public EquipoComercial(int cantidadElementos) {
		personas = new Persona[cantidadElementos];
		organizaciones = new Organizacion[cantidadElementos];
		negocios = new Negocio[cantidadElementos];
		actividades = new Actividad[cantidadElementos];
	}
	
	/**
	* Registrar una entidad
	* @param entidad Entidad a registrar
	* @return Devuelve falso si hay algún error, de lo contrario devuelve verdadero
	*/
	public boolean registrar(String entidad, Scanner teclado) {
		try {
			switch (entidad) {
				case "personas":
					registrarPersona(teclado);
					break;
				case "organizaciones":
					registrarOrganizacion(teclado);
					break;
				case "negocios":
					registrarNegocio(teclado);
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
	public void registrarPersona(Scanner teclado) throws Exception {
		int indice = indiceDisponiblePersonas();
		if (indice == -1) {
			throw new Exception("No se pueden registrar más personas.");
		}
		
		try {
			System.out.printf("Agregando persona %d.\n", indice + 1);
			personas[indice] = new Persona();
			
			System.out.print("Nombre: "); personas[indice].setNombre(teclado.nextLine());
			System.out.print("Teléfono: "); personas[indice].setTelefono(teclado.nextLine());
			
			String correoElectronico;
			do {
				System.out.print("Correo electrónico (usuario@dominio.com): ");
				correoElectronico = teclado.nextLine();
			} while(!Validar.correoElectronico(correoElectronico));
			personas[indice].setCorreoElectronico(correoElectronico);
		}
		catch (Exception e) {
			personas[indice] = null;
			throw e;
		}
	}
	
	/**
	* Registrar una organizacion
	 * @throws Exception 
	*/
	public void registrarOrganizacion(Scanner teclado) throws Exception {
		int indice = indiceDisponibleOrganizaciones();
		if (indice == -1) {
			throw new Exception("No se pueden registrar más organizaciones.");
		}
		
		try {
			System.out.printf("Agregando organizacion %d.\n", indice + 1);
			organizaciones[indice] = new Organizacion();
			
			System.out.print("Nombre: "); organizaciones[indice].setNombre(teclado.nextLine());
			System.out.print("Dirección: "); organizaciones[indice].setDireccion(teclado.nextLine());
			System.out.print("Teléfono: "); organizaciones[indice].setTelefono(teclado.nextLine());
		}
		catch (Exception e) {
			organizaciones[indice] = null;
			throw e;
		}
	}
	
	/**
	* Registrar una negocio
	 * @throws Exception 
	*/
	public void registrarNegocio(Scanner teclado) throws Exception {
		int indice = indiceDisponibleNegocios();
		if (indice == -1) {
			throw new Exception("No se pueden registrar más negocios.");
		}

		if (estaVacioPersonas() && estaVacioOrganizaciones()) {
			throw new Exception("No hay personas y organizaciones registradas para registrar un negocio.");
		}
		else if (estaVacioPersonas()) {
			throw new Exception("No hay personas registradas para registrar un negocio.");
		}
		else if (estaVacioOrganizaciones()) {
			throw new Exception("No hay organizaciones registradas para registrar un negocio.");
		}
		
		try {
			System.out.printf("Agregando negocio %d.\n", indice + 1);
			negocios[indice] = new Negocio();
			
			System.out.print("Título: "); negocios[indice].setTitulo(teclado.nextLine());
			System.out.print("Descripción: "); negocios[indice].setDescripcion(teclado.nextLine());
			System.out.print("Estado: "); negocios[indice].setEstado(teclado.nextLine());
			
			double valor = Double.NaN;
			do {
				System.out.print("Valor: ");
				try {
					valor = Double.parseDouble(teclado.nextLine());
				}
				catch (Exception e) {
					valor = Double.NaN;
				}
			} while (valor == Double.NaN);
			negocios[indice].setValor(valor);
			
			String fechaEstimadaCierre;
			do {
				System.out.print("Fecha estimada de cierre (dd/MM/yyyy): ");
				fechaEstimadaCierre = teclado.nextLine();
			} while(!Validar.fecha(fechaEstimadaCierre));
			negocios[indice].setFechaEstimadaCierre((new SimpleDateFormat("dd/MM/yyyy")).parse(fechaEstimadaCierre));
			
			System.out.println("-- Organizaciones --");
			int[] opcionesOrganizacion = new int[organizaciones.length];
			for (int i = 0; i < organizaciones.length; i++) {
				if (organizaciones[i] != null) {
					opcionesOrganizacion[i] = i + 1;
					System.out.printf("\t%s\t(%d)\n", organizaciones[i].getNombre(), opcionesOrganizacion[i]);
				}
				else {
					opcionesOrganizacion[i] = 0;
				}
			}
			
			int codigoOrganizacion;
			boolean opcionOrganizacionValida = true;
			do {
				System.out.print("Organización: ");
				try {
					codigoOrganizacion = Integer.parseInt(teclado.nextLine());
				}
				catch (Exception e) {
					codigoOrganizacion = 0;
				}
				for (int i = 0; i < opcionesOrganizacion.length; i++) {
					if (opcionesOrganizacion[i] != 0 && opcionesOrganizacion[i] == codigoOrganizacion) {
						opcionOrganizacionValida = false;
					}
				}
			} while (opcionOrganizacionValida);
			negocios[indice].setIndiceOrganizacion(codigoOrganizacion);
			
			System.out.println("-- Personas --");
			int[] opcionesPersona = new int[personas.length];
			for (int i = 0; i < personas.length; i++) {
				if (personas[i] != null) {
					opcionesPersona[i] = i + 1;
					System.out.printf("\t%s\t(%d)\n", personas[i].getNombre(), opcionesPersona[i]);
				}
				else {
					opcionesPersona[i] = 0;
				}
			}
			
			int codigoPersona;
			boolean opcionPersonaValida = true;
			do {
				System.out.print("Persona: ");
				try {
					codigoPersona = Integer.parseInt(teclado.nextLine());
				}
				catch (Exception e) {
					codigoPersona = 0;
				}
				for (int i = 0; i < opcionesPersona.length; i++) {
					if (opcionesPersona[i] != 0 && opcionesPersona[i] == codigoPersona) {
						opcionPersonaValida = false;
					}
				}
			} while (opcionPersonaValida);
			negocios[indice].setIndicePersona(codigoPersona);
		}
		catch (Exception e) {
			negocios[indice] = null;
			throw e;
		}
	}
	
	/**
	* Eliminar una entidad
	* @param entidad Entidad a eliminar
	* @return Devuelve falso si hay algún error, de lo contrario devuelve verdadero
	*/
	public boolean eliminar(String entidad, Scanner teclado) {
		try {
			switch (entidad) {
				case "personas":
					
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
	* Obtener el indice de la primera posición disponible del array de personas
	* @return Devuelve el indice si encuentra una posición disponible, de lo contrario devuelve -1
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
	* Obtener el indice de la primera posición disponible del array de organizaciones
	* @return Devuelve el indice si encuentra una posición disponible, de lo contrario devuelve -1
	*/
	private int indiceDisponibleOrganizaciones() {
		for (int i = 0; i < organizaciones.length; i++) {
			if (organizaciones[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	* Obtener el indice de la primera posición disponible del array de negocios
	* @return Devuelve el indice si encuentra una posición disponible, de lo contrario devuelve -1
	*/
	private int indiceDisponibleNegocios() {
		for (int i = 0; i < negocios.length; i++) {
			if (negocios[i] == null) {
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
	private boolean espacioDisponiblePersonas() {
		boolean resultado = false;
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
	private boolean espacioDisponibleOrganizaciones() {
		boolean resultado = false;
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
	private boolean espacioDisponibleNegocios() {
		boolean resultado = false;
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
	private boolean espacioDisponibleActividades() {
		boolean resultado = false;
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

	/**
	* Verifica si esta vacio el array de una entidad
	* @param entidad Entidad a verificar si el array esta vacio
	* @return Devuelve verdadero si el array de una entidad esta vacio, de lo contrario devuelve falso
	*/
	public boolean estaVacio(String entidad) {
		boolean resultado = false;
		
		switch (entidad) {
			case "personas":
				resultado = estaVacioPersonas();
				break;
			case "organizaciones":
				resultado = estaVacioOrganizaciones();
				break;
			case "negocios":
				resultado = estaVacioNegocios();
				break;
			case "actividades":
				resultado = estaVacioActividades();
				break;
		}
		
		return resultado;
	}
	
	/**
	* Verifica si esta vacio el array de personas
	* @return Devuelve verdadero si el array de personas esta vacio, de lo contrario devuelve falso
	*/
	private boolean estaVacioPersonas() {
		boolean resultado = false;
		int posicionesVacias = 0;
		
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] == null) {
				posicionesVacias++;
			}
		}
		
		if (posicionesVacias == personas.length) {
			resultado = true;
		}
		else {
			resultado = false;
		}
		
		return resultado;
	}
	
	/**
	* Verifica si esta vacio el array de organizaciones
	* @return Devuelve verdadero si el array de organizaciones esta vacio, de lo contrario devuelve falso
	*/
	private boolean estaVacioOrganizaciones() {
		boolean resultado = false;
		int posicionesVacias = 0;
		
		for (int i = 0; i < organizaciones.length; i++) {
			if (organizaciones[i] == null) {
				posicionesVacias++;
			}
		}
		
		if (posicionesVacias == organizaciones.length) {
			resultado = true;
		}
		else {
			resultado = false;
		}
		
		return resultado;
	}
	
	/**
	* Verifica si esta vacio el array de negocios
	* @return Devuelve verdadero si el array de negocios esta vacio, de lo contrario devuelve falso
	*/
	private boolean estaVacioNegocios() {
		boolean resultado = false;
		int posicionesVacias = 0;
		
		for (int i = 0; i < negocios.length; i++) {
			if (negocios[i] == null) {
				posicionesVacias++;
			}
		}
		
		if (posicionesVacias == negocios.length) {
			resultado = true;
		}
		else {
			resultado = false;
		}
		
		return resultado;
	}
	
	/**
	* Verifica si esta vacio el array de actividades
	* @return Devuelve verdadero si el array de actividades esta vacio, de lo contrario devuelve falso
	*/
	private boolean estaVacioActividades() {
		boolean resultado = false;
		int posicionesVacias = 0;
		
		for (int i = 0; i < actividades.length; i++) {
			if (actividades[i] == null) {
				posicionesVacias++;
			}
		}
		
		if (posicionesVacias == actividades.length) {
			resultado = true;
		}
		else {
			resultado = false;
		}
		
		return resultado;
	}
	
	public String toString() {
		StringBuilder resultado = new StringBuilder();
		
		resultado.append("\nLISTADO DE PERSONAS\n");
		for (Persona persona : personas) {
			resultado.append("----------------------------------------------------------\n");
			
			if (persona != null) {
				resultado.append("Nombre: " + persona.getNombre() + "\n");
				resultado.append("Teléfono: " + persona.getTelefono() + "\n");
				resultado.append("Correo electrónico: " + persona.getCorreoElectronico() + "\n");
			}
			else {
				resultado.append("NULL\n");
			}
		}
		
		resultado.append("\nLISTADO DE ORGANIZACIONES\n");
		for (Organizacion organizacion : organizaciones) {
			resultado.append("----------------------------------------------------------\n");
			
			if (organizacion != null) {
				resultado.append("Nombre: " + organizacion.getNombre() + "\n");
				resultado.append("Dirección: " + organizacion.getDireccion() + "\n");
				resultado.append("Teléfono: " + organizacion.getTelefono() + "\n");
			}
			else {
				resultado.append("NULL\n");
			}
		}
		
		resultado.append("\nLISTADO DE NEGOCIOS\n");
		for (Negocio negocio : negocios) {
			resultado.append("----------------------------------------------------------\n");
			
			if (negocio != null) {
				resultado.append("Título: " + negocio.getTitulo() + "\n");
				resultado.append("Descripción: " + negocio.getDescripcion() + "\n");
				resultado.append("Estado: " + negocio.getEstado() + "\n");
				resultado.append("Valor: " + negocio.getValor() + "\n");
				resultado.append("Fecha estimada de cierre: " + new SimpleDateFormat("dd/MM/yyyy").format(negocio.getFechaEstimadaCierre()) + "\n");
				resultado.append("Organización: " + organizaciones[negocio.getIndiceOrganizacion() - 1].getNombre() + "\n");
				resultado.append("Persona: " + personas[negocio.getIndicePersona() - 1].getNombre() + "\n");
			}
			else {
				resultado.append("NULL\n");
			}
		}
		
		return resultado.toString();
	}
}
