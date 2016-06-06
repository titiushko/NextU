package herramientas;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import entidades.Actividad;
import entidades.Negocio;
import entidades.Organizacion;
import entidades.Persona;

/**
 * @author titiushko
 */
public class OperacionesEntidades {
	protected Persona[] personas;
	protected Organizacion[] organizaciones;
	protected Negocio[] negocios;
	protected Actividad[] actividades;
	
	protected OperacionesEntidades(int cantidadElementos) {
		personas = new Persona[cantidadElementos];
		organizaciones = new Organizacion[cantidadElementos];
		negocios = new Negocio[cantidadElementos];
		actividades = new Actividad[cantidadElementos];
	}

	// PERSONAS
	/**
	 * Registrar una persona
	 */
	protected void registrarPersona(Scanner teclado) throws Exception {
		int indice = indiceDisponiblePersonas();
		if (indice == -1) {
			throw new Exception("No se pueden registrar más personas.");
		}
		
		try {
			System.out.printf("Agregando persona %d.\n", indice + 1);
			personas[indice] = new Persona();
			personas[indice].setNombre(Validar.atributoTexto("Nombre", teclado));
			personas[indice].setTelefono(Validar.atributoTexto("Teléfono", teclado));
			personas[indice].setCorreoElectronico(Validar.atributoCorreo("Correo electrónico (usuario@dominio.com)", teclado));
		}
		catch (Exception e) {
			personas[indice] = null;
			throw e;
		}
	}
	
	/**
	 * Buscar una persona
	 */
	protected void buscarPersona(Scanner teclado) throws Exception {
		int posicion = -1;
		String nombrePersona = Validar.atributoTexto("Nombre de la persona a consultar", teclado);
		
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] != null && personas[i].getNombre().toLowerCase().equals(nombrePersona.toLowerCase())) {
				posicion = i;
				break;
			}
		}

		if (posicion == -1) {
			System.out.println("No se encontró la persona.");
		}
		else {
			System.out.println("\nNombre: " + personas[posicion].getNombre());
			System.out.println("Teléfono: " + personas[posicion].getTelefono());
			System.out.println("Correo electrónico: " + personas[posicion].getCorreoElectronico());
		}
	}
	
	/**
	 * Modificar una persona
	 */
	protected void modificarPersona(Scanner teclado) throws Exception {
		if (estaVacioPersonas()) {
			throw new Exception("No hay personas registradas.");
		}

		try {
			int indice = seleccionarPersona(teclado);
			
			if (Validar.opcionSiNo("Modificar nombre (" + personas[indice].getNombre() + ")", teclado)) {
				personas[indice].setNombre(Validar.atributoTexto("Nombre", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar teléfono (" + personas[indice].getTelefono() + ")", teclado)) {
				personas[indice].setTelefono(Validar.atributoTexto("Teléfono", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar correo electrónico (" + personas[indice].getCorreoElectronico() + ")", teclado)) {
				personas[indice].setCorreoElectronico(Validar.atributoCorreo("Correo electrónico (usuario@dominio.com)", teclado));
			}
		}
		catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Eliminar una persona
	 * @return Devuelve verdadero si se eliminó la persona, de lo contrario devuelve falso
	 */
	protected boolean eliminarPersona(Scanner teclado) throws Exception {
		if (estaVacioPersonas()) {
			throw new Exception("No hay personas registradas.");
		}
		
		int indice = seleccionarPersona(teclado);
		
		if (Validar.opcionSiNo("Eliminar a " + personas[indice].getNombre(), teclado)) {
			personas[indice] = null;
			return true;
		}
		else {
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
	 * Valida si hay espacio disponible para registrar personas
	 * @return Devuelve falso si no hay espacio disponible para registrar mas personas, de lo contrario devuelve verdadero
	 */
	protected boolean espacioDisponiblePersonas() {
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
	 * Verifica si esta vacio el array de personas
	 * @return Devuelve verdadero si el array de personas esta vacio, de lo contrario devuelve falso
	 */
	protected boolean estaVacioPersonas() {
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
	 * Mostrar el listado de personas
	 * @return Indice de las posiciones que tienen registros de personas
	 */
	protected int[] listaPersonas() {
		return listaPersonas(-1);
	}
	
	/**
	 * Mostrar el listado de personas, ignorando el indice de la persona que se envía por parámetro
	 * @param ignorarIndice Indice de la persona que se ignora
	 * @return Indice de las posiciones que tienen registros de personas
	 */
	protected int[] listaPersonas(int ignorarIndice) {
		int[] opcionesPersona = new int[personas.length];
		
		System.out.println("Listado de Personas");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] != null && i != ignorarIndice) {
				opcionesPersona[i] = i + 1;
				System.out.printf("%d\t|\t%s\t|\t%s\t|\t%s\n", i + 1, personas[i].getNombre(), personas[i].getTelefono(), personas[i].getCorreoElectronico());
			}
			else {
				opcionesPersona[i] = 0;
			}
		}
		
		return opcionesPersona;
	}
	
	/**
	 * Validar que se seleccione una persona del listado de personas
	 * @return Opcion digitada por el usuario
	 */
	private int seleccionarPersona(Scanner teclado) {
		return seleccionarPersona(-1, teclado);
	}
	
	/**
	 * Validar que se seleccione una persona del listado de personas
	 * @param ignorarIndice Indice de la persona que se ignora
	 * @return Opcion digitada por el usuario
	 */
	private int seleccionarPersona(int ignorarIndice, Scanner teclado) {
		int codigoPersona;
		boolean opcionPersonaValida = true;
		int[] opcionesPersona = listaPersonas(ignorarIndice);
		
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
		
		System.out.println();
		
		return codigoPersona - 1;
	}
	
	// ORGANIZACIONES
	/**
	 * Registrar una organizacion
	 */
	protected void registrarOrganizacion(Scanner teclado) throws Exception {
		int indice = indiceDisponibleOrganizaciones();
		if (indice == -1) {
			throw new Exception("No se pueden registrar más organizaciones.");
		}
		
		try {
			System.out.printf("Agregando organización %d.\n", indice + 1);
			organizaciones[indice] = new Organizacion();
			organizaciones[indice].setNombre(Validar.atributoTexto("Nombre", teclado));
			organizaciones[indice].setDireccion(Validar.atributoTexto("Dirección", teclado));
			organizaciones[indice].setTelefono(Validar.atributoTexto("Teléfono", teclado));
		}
		catch (Exception e) {
			organizaciones[indice] = null;
			throw e;
		}
	}
	
	/**
	 * Buscar una organizacion
	 */
	protected void buscarOrganizacion(Scanner teclado) throws Exception {
		int posicion = -1;
		String nombreOrganizacion = Validar.atributoTexto("Nombre de la organización a consultar", teclado);
		
		for (int i = 0; i < organizaciones.length; i++) {
			if (organizaciones[i] != null && organizaciones[i].getNombre().toLowerCase().equals(nombreOrganizacion.toLowerCase())) {
				posicion = i;
				break;
			}
		}

		if (posicion == -1) {
			System.out.println("No se encontró la organización.");
		}
		else {
			System.out.println("\nNombre: " + organizaciones[posicion].getNombre());
			System.out.println("Dirección: " + organizaciones[posicion].getDireccion());
			System.out.println("Teléfono: " + organizaciones[posicion].getTelefono());
		}
	}
	
	/**
	 * Modificar una organizacion
	 */
	protected void modificarOrganizacion(Scanner teclado) throws Exception {
		if (estaVacioOrganizaciones()) {
			throw new Exception("No hay organizacions registradas.");
		}

		try {
			int indice = seleccionarOrganizacion(teclado);
			
			if (Validar.opcionSiNo("Modificar nombre (" + organizaciones[indice].getNombre() + ")", teclado)) {
				organizaciones[indice].setNombre(Validar.atributoTexto("Nombre", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar dirección (" + organizaciones[indice].getDireccion() + ")", teclado)) {
				organizaciones[indice].setDireccion(Validar.atributoTexto("Dirección", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar teléfono (" + organizaciones[indice].getTelefono() + ")", teclado)) {
				organizaciones[indice].setTelefono(Validar.atributoTexto("Teléfono", teclado));
			}
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Eliminar una organizacion
	 * @return Devuelve verdadero si se eliminó la organizacion, de lo contrario devuelve falso
	 */
	protected boolean eliminarOrganizacion(Scanner teclado) throws Exception {
		if (estaVacioOrganizaciones()) {
			throw new Exception("No hay organizaciones registradas.");
		}
		
		int indice = seleccionarOrganizacion(teclado);
		
		if (Validar.opcionSiNo("Eliminar a " + organizaciones[indice].getNombre(), teclado)) {
			organizaciones[indice] = null;
			return true;
		}
		else {
			return false;
		}
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
	 * Valida si hay espacio disponible para registrar organizaciones
	 * @return Devuelve falso si no hay espacio disponible para registrar mas organizaciones, de lo contrario devuelve verdadero
	 */
	protected boolean espacioDisponibleOrganizaciones() {
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
	 * Verifica si esta vacio el array de organizaciones
	 * @return Devuelve verdadero si el array de organizaciones esta vacio, de lo contrario devuelve falso
	 */
	protected boolean estaVacioOrganizaciones() {
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
	 * Mostrar el listado de organizaciones
	 * @return Indice de las posiciones que tienen registros de organizaciones
	 */
	protected int[] listaOrganizaciones() {
		return listaOrganizaciones(-1);
	}
	
	/**
	 * Mostrar el listado de organizaciones, ignorando el indice de la organización que se envía por parámetro
	 * @param ignorarIndice Indice de la organización que se ignora
	 * @return Indice de las posiciones que tienen registros de organizaciones
	 */
	protected int[] listaOrganizaciones(int ignorarIndice) {
		int[] opcionesOrganizacion = new int[organizaciones.length];
		
		System.out.println("Listado de Organizaciones");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for (int i = 0; i < organizaciones.length; i++) {
			if (organizaciones[i] != null && i != ignorarIndice) {
				opcionesOrganizacion[i] = i + 1;
				System.out.printf("%d\t|\t%s\t|\t%s\t|\t%s\n", i + 1, organizaciones[i].getNombre(), organizaciones[i].getDireccion(), organizaciones[i].getTelefono());
			}
			else {
				opcionesOrganizacion[i] = 0;
			}
		}
		
		return opcionesOrganizacion;
	}
	
	/**
	 * Validar que se seleccione una organizacion del listado de organizaciones
	 * @return Opcion digitada por el usuario
	 */
	private int seleccionarOrganizacion(Scanner teclado) {
		return seleccionarOrganizacion(-1, teclado);
	}
	
	/**
	 * Validar que se seleccione una organización del listado de organizaciones
	 * @param ignorarIndice Indice de la organización que se ignora
	 * @return Opcion digitada por el usuario
	 */
	private int seleccionarOrganizacion(int ignorarIndice, Scanner teclado) {
		int codigoOrganizacion;
		boolean opcionOrganizacionValida = true;
		int[] opcionesOrganizacion = listaOrganizaciones(ignorarIndice);
		
		do {
			System.out.print("Organizacion: ");
			
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
		
		System.out.println();
		
		return codigoOrganizacion - 1;
	}
	
	// NEGOCIOS
	/**
	 * Registrar un negocio
	 */
	protected void registrarNegocio(Scanner teclado) throws Exception {
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
			negocios[indice].setTitulo(Validar.atributoTexto("Título", teclado));
			negocios[indice].setDescripcion(Validar.atributoTexto("Descripción", teclado));
			negocios[indice].setEstado(Validar.atributoTexto("Estado", teclado));
			negocios[indice].setValor(Validar.atributoDecimal("Valor", teclado));
			negocios[indice].setFechaEstimadaCierre(Validar.atributoFecha("Fecha estimada de cierre (dd/MM/yyyy)", teclado));
			negocios[indice].setIndiceOrganizacion(seleccionarOrganizacion(teclado));
			negocios[indice].setIndicePersona(seleccionarPersona(teclado));
		}
		catch (Exception e) {
			negocios[indice] = null;
			throw e;
		}
	}
	
	/**
	 * Buscar una negocio
	 */
	protected void buscarNegocio(Scanner teclado) throws Exception {
		int posicion = -1;
		String tituloNegocio = Validar.atributoTexto("Título del negocio a consultar", teclado);
		
		for (int i = 0; i < negocios.length; i++) {
			if (negocios[i] != null && negocios[i].getTitulo().toLowerCase().equals(tituloNegocio.toLowerCase())) {
				posicion = i;
				break;
			}
		}

		if (posicion == -1) {
			System.out.println("No se encontró el negocio.");
		}
		else {
			System.out.println("\nTítulo: " + negocios[posicion].getTitulo());
			System.out.println("Descripción: " + negocios[posicion].getDescripcion());
			System.out.println("Estado: " + negocios[posicion].getEstado());
			System.out.println("Valor: " + negocios[posicion].getValor());
			System.out.println("Fecha estimada de cierre: " + new SimpleDateFormat("dd/MM/yyyy").format(negocios[posicion].getFechaEstimadaCierre()));
			System.out.println("Organización: " + (organizaciones[negocios[posicion].getIndiceOrganizacion()] != null ? organizaciones[negocios[posicion].getIndiceOrganizacion()].getNombre() : ""));
			System.out.println("Persona: " + (personas[negocios[posicion].getIndicePersona()] != null ? personas[negocios[posicion].getIndicePersona()].getNombre() : ""));
		}
	}
	
	/**
	 * Modificar una negocio
	 */
	protected void modificarNegocio(Scanner teclado) throws Exception {
		if (estaVacioNegocios()) {
			throw new Exception("No hay negocios registradas.");
		}

		try {
			int indice = seleccionarNegocio(teclado);
			
			if (Validar.opcionSiNo("Modificar título (" + negocios[indice].getTitulo() + ")", teclado)) {
				negocios[indice].setTitulo(Validar.atributoTexto("Título", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar descripción (" + negocios[indice].getDescripcion() + ")", teclado)) {
				negocios[indice].setDescripcion(Validar.atributoTexto("Descripción", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar estado (" + negocios[indice].getEstado() + ")", teclado)) {
				negocios[indice].setEstado(Validar.atributoTexto("Estado", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar valor (" + negocios[indice].getValor() + ")", teclado)) {
				negocios[indice].setValor(Validar.atributoDecimal("Valor", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar fecha estimada de cierre (" + new SimpleDateFormat("dd/MM/yyyy").format(negocios[indice].getFechaEstimadaCierre()) + ")", teclado)) {
				negocios[indice].setFechaEstimadaCierre(Validar.atributoFecha("Fecha estimada de cierre (dd/MM/yyyy)", teclado));
			}
			
			boolean tieneOrganizacion = organizaciones[negocios[indice].getIndiceOrganizacion()] != null ? true : false;
			if (Validar.opcionSiNo("Modificar organización (" + (tieneOrganizacion ? organizaciones[negocios[indice].getIndiceOrganizacion()].getNombre() : "") + ")", teclado)) {
				negocios[indice].setIndiceOrganizacion(seleccionarOrganizacion(tieneOrganizacion ? negocios[indice].getIndiceOrganizacion() : -1, teclado));
			}
			
			boolean tienePersona = personas[negocios[indice].getIndicePersona()] != null ? true : false;
			if (Validar.opcionSiNo("Modificar persona (" + (tienePersona ? personas[negocios[indice].getIndicePersona()].getNombre() : "") + ")", teclado)) {
				negocios[indice].setIndicePersona(seleccionarPersona(tienePersona ? negocios[indice].getIndicePersona() : -1, teclado));
			}
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Eliminar una negocio
	 * @return Devuelve verdadero si se eliminó la negocio, de lo contrario devuelve falso
	 */
	protected boolean eliminarNegocio(Scanner teclado) throws Exception {
		if (estaVacioNegocios()) {
			throw new Exception("No hay negocios registradas.");
		}
		
		int indice = seleccionarNegocio(teclado);
		
		if (Validar.opcionSiNo("Eliminar a " + negocios[indice].getTitulo(), teclado)) {
			negocios[indice] = null;
			return true;
		}
		else {
			return false;
		}
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
	 * Valida si hay espacio disponible para registrar negocios
	 * @return Devuelve falso si no hay espacio disponible para registrar mas negocios, de lo contrario devuelve verdadero
	 */
	protected boolean espacioDisponibleNegocios() {
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
	 * Verifica si esta vacio el array de negocios
	 * @return Devuelve verdadero si el array de negocios esta vacio, de lo contrario devuelve falso
	 */
	protected boolean estaVacioNegocios() {
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
	 * Mostrar el listado de negocios
	 * @return Indice de las posiciones que tienen registros de negocios
	 */
	protected int[] listaNegocios() {
		return listaNegocios(-1);
	}
	
	/**
	 * Mostrar el listado de negocios, ignorando el indice del negocio que se envía por parámetro
	 * @param ignorarIndice Indice del negocio que se ignora
	 * @return Indice de las posiciones que tienen registros de negocios
	 */
	protected int[] listaNegocios(int ignorarIndice) {
		int[] opcionesNegocio = new int[negocios.length];
		
		System.out.println("Listado de Negocios");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		
		for (int i = 0; i < negocios.length; i++) {
			if (negocios[i] != null && i != ignorarIndice) {
				opcionesNegocio[i] = i + 1;
				System.out.printf("%d\t|\t%s\t|\t%s\t|\t%s\n", i + 1, negocios[i].getTitulo(), negocios[i].getValor(), new SimpleDateFormat("dd/MM/yyyy").format(negocios[i].getFechaEstimadaCierre()));
			}
			else {
				opcionesNegocio[i] = 0;
			}
		}
		
		return opcionesNegocio;
	}
	
	/**
	 * Validar que se seleccione una negocio del listado de negocios
	 * @return Opcion digitada por el usuario
	 */
	private int seleccionarNegocio(Scanner teclado) {
		return seleccionarNegocio(-1, teclado);
	}
	
	/**
	 * Validar que se seleccione una negocio del listado de negocios
	 * @param ignorarIndice Indice del negocio que se ignora
	 * @return Opcion digitada por el usuario
	 */
	private int seleccionarNegocio(int ignorarIndice, Scanner teclado) {
		int codigoNegocio;
		boolean opcionNegocioValida = true;
		int[] opcionesNegocio = listaNegocios(ignorarIndice);
		
		do {
			System.out.print("Negocio: ");
			
			try {
				codigoNegocio = Integer.parseInt(teclado.nextLine());
			}
			catch (Exception e) {
				codigoNegocio = 0;
			}
			
			for (int i = 0; i < opcionesNegocio.length; i++) {
				if (opcionesNegocio[i] != 0 && opcionesNegocio[i] == codigoNegocio) {
					opcionNegocioValida = false;
				}
			}
		} while (opcionNegocioValida);
		
		System.out.println();
		
		return codigoNegocio - 1;
	}
	
	// ACTIVIDADES
	/**
	 * Registrar un actividad
	 */
	protected void registrarActividad(Scanner teclado) throws Exception {
		int indice = indiceDisponibleActividades();
		if (indice == -1) {
			throw new Exception("No se pueden registrar más actividades.");
		}

		if (estaVacioPersonas() && estaVacioOrganizaciones() && estaVacioNegocios()) {
			throw new Exception("No hay personas, organizaciones y negocios registrados para registrar una actividad.");
		}
		else if (estaVacioPersonas()) {
			throw new Exception("No hay personas registradas para registrar una actividad.");
		}
		else if (estaVacioOrganizaciones()) {
			throw new Exception("No hay organizaciones registradas para registrar una actividad.");
		}
		else if (estaVacioNegocios()) {
			throw new Exception("No hay negocios registrados para registrar una actividad.");
		}
		
		try {
			System.out.printf("Agregando actividad %d.\n", indice + 1);
			actividades[indice] = new Actividad();
			actividades[indice].setDescripcion(Validar.atributoTexto("Descripción", teclado));
			actividades[indice].setTipo(Validar.atributoTexto("Tipo", teclado));
			actividades[indice].setDuracion(Validar.atributoEntero("Duración (horas)", teclado));
			actividades[indice].setFecha(Validar.atributoFecha("Fecha (dd/MM/yyyy)", teclado));
			actividades[indice].setHora(Validar.atributoHora("Hora", teclado));
			actividades[indice].setIndiceOrganizacion(seleccionarOrganizacion(teclado));
			actividades[indice].setIndicePersona(seleccionarPersona(teclado));
			actividades[indice].setIndiceNegocio(seleccionarNegocio(teclado));
		}
		catch (Exception e) {
			actividades[indice] = null;
			throw e;
		}
	}
	
	/**
	 * Buscar una actividad
	 */
	protected void buscarActividad(Scanner teclado) throws Exception {
		int posicion = -1;
		String tipoActividad = Validar.atributoTexto("Tipo de la actividad a consultar", teclado);
		
		for (int i = 0; i < actividades.length; i++) {
			if (actividades[i] != null && actividades[i].getTipo().toLowerCase().equals(tipoActividad.toLowerCase())) {
				posicion = i;
				break;
			}
		}

		if (posicion == -1) {
			System.out.println("No se encontró la actividad.");
		}
		else {
			System.out.println("\nTipo: " + actividades[posicion].getTipo());
			System.out.println("Descripción: " + actividades[posicion].getDescripcion());
			System.out.println("Duración: " + actividades[posicion].getDuracion());
			System.out.println("Fecha: " + new SimpleDateFormat("dd/MM/yyyy").format(actividades[posicion].getFecha()));
			System.out.println("Hora: " + new SimpleDateFormat("HH:mm").format(actividades[posicion].getHora()));
			System.out.println("Organización: " + (organizaciones[actividades[posicion].getIndiceOrganizacion()] != null ? organizaciones[actividades[posicion].getIndiceOrganizacion()].getNombre() : ""));
			System.out.println("Persona: " + (personas[actividades[posicion].getIndicePersona()] != null ? personas[actividades[posicion].getIndicePersona()].getNombre() : ""));
			System.out.println("Negocio: " + (negocios[actividades[posicion].getIndiceNegocio()] != null ? negocios[actividades[posicion].getIndiceNegocio()].getTitulo() : ""));
		}
	}
	/**
	 * Modificar una actividad
	 */
	protected void modificarActividad(Scanner teclado) throws Exception {
		if (estaVacioActividades()) {
			throw new Exception("No hay actividades registradas.");
		}

		try {
			int indice = seleccionarActividad(teclado);
			
			if (Validar.opcionSiNo("Modificar descripción (" + actividades[indice].getDescripcion() + ")", teclado)) {
				actividades[indice].setDescripcion(Validar.atributoTexto("Descripción", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar tipo (" + actividades[indice].getTipo() + ")", teclado)) {
				actividades[indice].setTipo(Validar.atributoTexto("Tipo", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar duración (" + actividades[indice].getDuracion() + ")", teclado)) {
				actividades[indice].setDuracion(Validar.atributoEntero("Duración (horas)", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar fecha (" + new SimpleDateFormat("dd/MM/yyyy").format(actividades[indice].getFecha()) + ")", teclado)) {
				actividades[indice].setFecha(Validar.atributoFecha("Fecha (dd/MM/yyyy)", teclado));
			}
			
			if (Validar.opcionSiNo("Modificar hora (" + new SimpleDateFormat("HH:mm").format(actividades[indice].getHora()) + ")", teclado)) {
				actividades[indice].setHora(Validar.atributoHora("Hora", teclado));
			}
			
			boolean tieneOrganizacion = organizaciones[actividades[indice].getIndiceOrganizacion()] != null ? true : false;
			if (Validar.opcionSiNo("Modificar organización (" + (tieneOrganizacion ? organizaciones[actividades[indice].getIndiceOrganizacion()].getNombre() : "") + ")", teclado)) {
				actividades[indice].setIndiceOrganizacion(seleccionarOrganizacion(tieneOrganizacion ? actividades[indice].getIndiceOrganizacion() : -1, teclado));
			}
			
			boolean tienePersona = personas[actividades[indice].getIndicePersona()] != null ? true : false;
			if (Validar.opcionSiNo("Modificar persona (" + (tienePersona ? personas[actividades[indice].getIndicePersona()].getNombre() : "") + ")", teclado)) {
				actividades[indice].setIndicePersona(seleccionarPersona(tienePersona ? actividades[indice].getIndicePersona() : -1, teclado));
			}
			
			boolean tieneNegocio = negocios[actividades[indice].getIndiceNegocio()] != null ? true : false;
			if (Validar.opcionSiNo("Modificar negocio (" + (tieneNegocio ? negocios[actividades[indice].getIndiceNegocio()].getTitulo() : "") + ")", teclado)) {
				actividades[indice].setIndiceNegocio(seleccionarNegocio(tieneNegocio ? actividades[indice].getIndiceNegocio() : -1, teclado));
			}
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Eliminar una actividad
	 * @return Devuelve verdadero si se eliminó la actividad, de lo contrario devuelve falso
	 */
	protected boolean eliminarActividad(Scanner teclado) throws Exception {
		if (estaVacioActividades()) {
			throw new Exception("No hay actividades registradas.");
		}
		
		int indice = seleccionarActividad(teclado);

		if (Validar.opcionSiNo("Eliminar a " + actividades[indice].getTipo(), teclado)) {
			actividades[indice] = null;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Obtener el indice de la primera posición disponible del array de actividades
	 * @return Devuelve el indice si encuentra una posición disponible, de lo contrario devuelve -1
	 */
	private int indiceDisponibleActividades() {
		for (int i = 0; i < actividades.length; i++) {
			if (actividades[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Valida si hay espacio disponible para registrar actividades
	 * @return Devuelve falso si no hay espacio disponible para registrar mas actividades, de lo contrario devuelve verdadero
	 */
	protected boolean espacioDisponibleActividades() {
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
	 * Verifica si esta vacio el array de actividades
	 * @return Devuelve verdadero si el array de actividades esta vacio, de lo contrario devuelve falso
	 */
	protected boolean estaVacioActividades() {
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
	
	/**
	 * Mostrar el listado de actividades
	 * @return Indice de las posiciones que tienen registros de actividades
	 */
	protected int[] listaActividades() {
		return listaActividades(-1);
	}
	
	/**
	 * Mostrar el listado de actividades, ignorando el indice de la actividad que se envía por parámetro
	 * @param ignorarIndice Indice de la actividad que se ignora
	 * @return Indice de las posiciones que tienen registros de actividades
	 */
	protected int[] listaActividades(int ignorarIndice) {
		int[] opcionesActividad = new int[actividades.length];
		
		System.out.println("Listado de Actividades");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		
		for (int i = 0; i < actividades.length; i++) {
			if (actividades[i] != null && i != ignorarIndice) {
				opcionesActividad[i] = i + 1;
				System.out.printf("%d\t|\t%s\t|\t%s\t|\t%s\n", i + 1, actividades[i].getTipo(), new SimpleDateFormat("dd/MM/yyyy").format(actividades[i].getFecha()), new SimpleDateFormat("HH:mm").format(actividades[i].getHora()));
			}
			else {
				opcionesActividad[i] = 0;
			}
		}
		
		return opcionesActividad;
	}
	
	/**
	 * Validar que se seleccione una actividad del listado de actividades
	 * @return Opcion digitada por el usuario
	 */
	private int seleccionarActividad(Scanner teclado) {
		int codigoActividad;
		boolean opcionActividadValida = true;
		int[] opcionesActividad = listaActividades();
		
		do {
			System.out.print("Actividad: ");
			
			try {
				codigoActividad = Integer.parseInt(teclado.nextLine());
			}
			catch (Exception e) {
				codigoActividad = 0;
			}
			
			for (int i = 0; i < opcionesActividad.length; i++) {
				if (opcionesActividad[i] != 0 && opcionesActividad[i] == codigoActividad) {
					opcionActividadValida = false;
				}
			}
		} while (opcionActividadValida);
		
		System.out.println();
		
		return codigoActividad - 1;
	}
}
