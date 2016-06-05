import java.util.Scanner;

/**
 * @author titiushko
 */
public class Main {
	private static Scanner teclado = new Scanner(System.in);
	
	// Se podría pedir al usuario que decida la cantidad de elementos que se puedan registrar de las entidades
	// Pero para este ejemplo se define una cantidad específica para agilizar la experiencia de usuario
	private static EquipoComercial equipoComercial = new EquipoComercial(5);
	
	public static void main(String[] args) {
		boolean salirPrograma = true;
		int opcionMenu;

		try {
			equipoComercial.cargarDatosEjemplo();
			
			do {
				opcionMenu = menu("principal");
				System.out.println();
				
				switch (opcionMenu) {
					case 1:
						ejecutarSubMenu("personas");
						break;
					case 2:
						ejecutarSubMenu("organizaciones");
						break;
					case 3:
						ejecutarSubMenu("negocios");
						break;
					case 4:
						ejecutarSubMenu("actividades");
						break;
					case 5:	// Salir del programa
						salirPrograma = false;
						break;
					default:
						opcionMenu = menu("principal");
						System.out.println();
						break;
				}
			} while (salirPrograma);
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nEl programa ha terminado.\n");
			System.out.println("*********\n*RESUMEN*\n*********");
			System.out.println(equipoComercial);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			teclado.close();
		}
	}
	
	/**
	 * Ejecuta las operaciones del sub menú
	 * @param entidad Entidad a la cual se ejecutaran las operaciones
	 */
	public static void ejecutarSubMenu(String entidad) throws Exception {
		boolean salirSubMenu = true;
		int opcionSubMenu;
		
		do {
			opcionSubMenu = menu(entidad);
			System.out.println();
			
			switch (opcionSubMenu) {
				case 1:
					if (equipoComercial.espacioDisponible(entidad)) {
						if (equipoComercial.registrar(entidad, teclado)) {
							System.out.println("Se registró éxitosamente.");
						}
						else {
							System.out.println("No se pudo registrar.");
						}
					}
					else {
						System.out.printf("Limite de %s registrados. No se pueden registrar mas %s.\n", entidad, entidad);
					}
					break;
				case 2:
					equipoComercial.buscar(entidad, teclado);
					break;
				case 4:
					if (!equipoComercial.estaVacio(entidad)) {
						switch (equipoComercial.eliminar(entidad, teclado)) {
							case 1:
								System.out.println("Se eliminó éxitosamente.");
								break;
							case 0:
								System.out.println("No se eliminó.");
								break;
							case -1:
								System.out.println("No se pudo eliminar.");
								break;
						}
					}
					else {
						System.out.printf("No hay %s que eliminar. No hay registros de %s.\n", entidad, entidad);
					}
					break;
				case 5:	// Regresar al menú principal
					salirSubMenu = false;
					break;
				default:
					opcionSubMenu = menu(entidad);
					System.out.println();
					break;
			}
		} while (salirSubMenu);
	}

	/**
	 * Mostrar en pantalla las opciones del menú principal y los sub menús
	 * @param nivelMenu Menú que se quiere mostrar
	 * @return Opción digitada por el usuario, si no es una opción valida se devuelve 0
	 */
	public static int menu(String nivelMenu) {
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("\t\tMENÚ " + nivelMenu.toUpperCase());
		System.out.println("-----------------------------------------------");
		
		switch (nivelMenu) {
			case "personas":
			case "organizaciones":
			case "negocios":
			case "actividades":
				System.out.println("Agregar\t\t\t\t\t[1]");
				System.out.println("Consultar\t\t\t\t[2]");
				System.out.println("Modificar\t\t\t\t[3]");
				System.out.println("Eliminar\t\t\t\t[4]");
				System.out.println("Regresar\t\t\t\t[5]");
				break;
			case "principal":
			default:
				System.out.println("Personas\t\t\t\t[1]");
				System.out.println("Organizaciones\t\t\t\t[2]");
				System.out.println("Negocios\t\t\t\t[3]");
				System.out.println("Actividades\t\t\t\t[4]");
				System.out.println("Salir\t\t\t\t\t[5]");
				break;
		}
		
		System.out.println("-----------------------------------------------");
		System.out.print("Por favor digite una opción: ");
		
		try {
			return Integer.parseInt(teclado.nextLine());
		}
		catch (Exception e) {
			return 0;
		}
	}
}
