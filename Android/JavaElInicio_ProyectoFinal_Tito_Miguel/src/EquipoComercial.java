import java.util.Scanner;
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
}
