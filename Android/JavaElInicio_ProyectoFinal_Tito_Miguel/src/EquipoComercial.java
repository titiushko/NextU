import java.text.SimpleDateFormat;
import java.util.Scanner;

import entidades.Actividad;
import entidades.Negocio;
import entidades.Organizacion;
import entidades.Persona;
import herramientas.OperacionesEntidades;

/**
 * @author titiushko
 */
public class EquipoComercial extends OperacionesEntidades {
	/**
	 * Inicializar la cantidad de elementos que se puedan registrar de las entidades
	 * @param cantidadElementos Cantidad de registros que se podrán almacenar de las entidades 
	 */
	public EquipoComercial(int cantidadElementos) {
		super(cantidadElementos);
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
					registrarActividad(teclado);
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
	 * Buscar una entidad
	 * @param entidad Entidad a buscar
	 * @param teclado
	 */
	public void buscar(String entidad, Scanner teclado) {
		try {
			switch (entidad) {
				case "personas":
					buscarPersona(teclado);
					break;
				case "organizaciones":
					buscarOrganizacion(teclado);
					break;
				case "negocios":
					buscarNegocio(teclado);
					break;
				case "actividades":
					buscarActividad(teclado);
					break;
			}
		}
		catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	/**
	 * Modificar una entidad
	 * @param entidad Entidad a modificar
	 * @return Devuelve falso si hay algún error, de lo contrario devuelve verdadero
	 */
	public boolean modificar(String entidad, Scanner teclado) {
		try {
			switch (entidad) {
				case "personas":
					modificarPersona(teclado);
					break;
				case "organizaciones":
					modificarOrganizacion(teclado);
					break;
				case "negocios":
					modificarNegocio(teclado);
					break;
				case "actividades":
					modificarActividad(teclado);
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
	 * Eliminar una entidad
	 * @param entidad Entidad a eliminar
	 * @return Devuelve -1 si hay algún error, 0 si no se eliminó o 1 si se eliminó la entidad
	 */
	public int eliminar(String entidad, Scanner teclado) {
		int resultado = -1;
		
		try {
			switch (entidad) {
				case "personas":
					if (eliminarPersona(teclado)) {
						resultado = 1;
					}
					else {
						resultado = 0;
					}
					break;
				case "organizaciones":
					if (eliminarOrganizacion(teclado)) {
						resultado = 1;
					}
					else {
						resultado = 0;
					}
					break;
				case "negocios":
					if (eliminarNegocio(teclado)) {
						resultado = 1;
					}
					else {
						resultado = 0;
					}
					break;
				case "actividades":
					if (eliminarActividad(teclado)) {
						resultado = 1;
					}
					else {
						resultado = 0;
					}
					break;
			}
			
			return resultado;
		}
		catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			return resultado;
		}
	}
	
	/**
	 * Mostrar la lista de registros de una entidad
	 * @param entidad Entidad a buscar
	 * @param teclado
	 */
	public void listado(String entidad) {
		try {
			switch (entidad) {
				case "personas":
					listaPersonas();
					break;
				case "organizaciones":
					listaOrganizaciones();
					break;
				case "negocios":
					listaNegocios();
					break;
				case "actividades":
					listaActividades();
					break;
			}
		}
		catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
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
				resultado.append("VACÍO\n");
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
				resultado.append("VACÍO\n");
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
				resultado.append("Organización: " + (organizaciones[negocio.getIndiceOrganizacion()] != null ? organizaciones[negocio.getIndiceOrganizacion()].getNombre() : "") + "\n");
				resultado.append("Persona: " + (personas[negocio.getIndicePersona()] != null ? personas[negocio.getIndicePersona()].getNombre() : "") + "\n");
			}
			else {
				resultado.append("VACÍO\n");
			}
		}
		
		resultado.append("\nLISTADO DE ACTIVIDADES\n");
		for (Actividad actividad : actividades) {
			resultado.append("----------------------------------------------------------\n");
			
			if (actividad != null) {
				resultado.append("Descripción: " + actividad.getDescripcion() + "\n");
				resultado.append("Tipo: " + actividad.getTipo() + "\n");
				resultado.append("Duración: " + actividad.getDuracion() + "\n");
				resultado.append("Fecha: " + new SimpleDateFormat("dd/MM/yyyy").format(actividad.getFecha()) + "\n");
				resultado.append("Hora: " + new SimpleDateFormat("HH:mm").format(actividad.getHora()) + "\n");
				resultado.append("Organización: " + (organizaciones[actividad.getIndiceOrganizacion()] != null ? organizaciones[actividad.getIndiceOrganizacion()].getNombre() : "") + "\n");
				resultado.append("Persona: " + (personas[actividad.getIndicePersona()] != null ? personas[actividad.getIndicePersona()].getNombre() : "") + "\n");
				resultado.append("Negocio: " + (negocios[actividad.getIndiceNegocio()] != null ? negocios[actividad.getIndiceNegocio()].getTitulo() : "") + "\n");
			}
			else {
				resultado.append("VACÍO\n");
			}
		}
		
		return resultado.toString();
	}

	/**
	 * Inicializar datos de ejemplos en las entidades
	 */
	public void cargarDatosEjemplo(int cantidadElementos) {
		try {
			if (cantidadElementos < 5) {
				cantidadElementos = 5;
				personas = new Persona[cantidadElementos];
				organizaciones = new Organizacion[cantidadElementos];
				negocios = new Negocio[cantidadElementos];
				actividades = new Actividad[cantidadElementos];
			}
			
			int indice;
			
			// personas
			indice = 1;
			personas[indice] = new Persona();
			personas[indice].setNombre("Tito");
			personas[indice].setTelefono("784512");;
			personas[indice].setCorreoElectronico("tito@gmail.com");
			
			indice = 3;
			personas[indice] = new Persona();
			personas[indice].setNombre("Javier");
			personas[indice].setTelefono("120457");;
			personas[indice].setCorreoElectronico("javier@gmail.com");
			
			// organizaciones
			indice = 2;
			organizaciones[indice] = new Organizacion();
			organizaciones[indice].setNombre("Creativa");
			organizaciones[indice].setDireccion("San Salvador");
			organizaciones[indice].setTelefono("789456");
			
			indice = 3;
			organizaciones[indice] = new Organizacion();
			organizaciones[indice].setNombre("PokeCenter");
			organizaciones[indice].setDireccion("Zacatecoluca");
			organizaciones[indice].setTelefono("324589");
			
			// negocios
			indice = 0;
			negocios[indice] = new Negocio();
			negocios[indice].setTitulo("Comida Rápida");
			negocios[indice].setDescripcion("Gordura máxima");
			negocios[indice].setEstado("Buenísima");
			negocios[indice].setValor(2.5);
			negocios[indice].setFechaEstimadaCierre((new SimpleDateFormat("dd/MM/yyyy")).parse("15/09/2016"));
			negocios[indice].setIndiceOrganizacion(3);
			negocios[indice].setIndicePersona(3);
			
			indice = 4;
			negocios[indice] = new Negocio();
			negocios[indice].setTitulo("Financiero");
			negocios[indice].setDescripcion("Como ganar rupias");
			negocios[indice].setEstado("Magía");
			negocios[indice].setValor(45.73);
			negocios[indice].setFechaEstimadaCierre((new SimpleDateFormat("dd/MM/yyyy")).parse("19/05/2018"));
			negocios[indice].setIndiceOrganizacion(2);
			negocios[indice].setIndicePersona(1);
			
			// actividades
			indice = 3;
			actividades[indice] = new Actividad();
			actividades[indice].setDescripcion("Fiesta en la piscina");
			actividades[indice].setTipo("Infantil");
			actividades[indice].setDuracion(2);
			actividades[indice].setFecha((new SimpleDateFormat("dd/MM/yyyy")).parse("22/07/2016"));
			actividades[indice].setHora((new SimpleDateFormat("HH:mm")).parse("03:20"));
			actividades[indice].setIndiceOrganizacion(2);
			actividades[indice].setIndicePersona(3);
			actividades[indice].setIndiceNegocio(0);
			
			indice = 4;
			actividades[indice] = new Actividad();
			actividades[indice].setDescripcion("Venta de libros");
			actividades[indice].setTipo("Todo público");
			actividades[indice].setDuracion(4);
			actividades[indice].setFecha((new SimpleDateFormat("dd/MM/yyyy")).parse("05/06/2016"));
			actividades[indice].setHora((new SimpleDateFormat("HH:mm")).parse("15:45"));
			actividades[indice].setIndiceOrganizacion(3);
			actividades[indice].setIndicePersona(1);
			actividades[indice].setIndiceNegocio(4);
		}
		catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
