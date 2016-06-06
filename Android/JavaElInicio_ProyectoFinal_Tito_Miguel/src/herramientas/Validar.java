package herramientas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author titiushko
 */
public class Validar {
	/**
	 * @see http://jbviera.blogspot.com/2012/04/validar-si-una-fecha-es-valida-con-java.html
	 */
	public static boolean fecha(String fecha) {
		try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        }
		catch (ParseException e) {
            return false;
        }
        return true;
	}
	
	public static boolean hora(String hora) {
		try {
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm", Locale.getDefault());
            formatoHora.setLenient(false);
            formatoHora.parse(hora);
        }
		catch (ParseException e) {
            return false;
        }
        return true;
	}

	/**
	 * @see http://eos87.blogspot.com/2008/01/validacin-de-email-y-fecha-en-java.html
	 */
	public static boolean correoElectronico(String correo) {
		Pattern pat = null;
		Matcher mat = null;
		pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
		mat = pat.matcher(correo);
		if (mat.find()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Validar la información de los atributos de tipo String
	 * @param etiqueta Texto para solicitar el atributo
	 * @return Atributo validado
	 */
	public static String atributoTexto(String etiqueta, Scanner teclado) throws Exception {
		return atributoTexto(etiqueta, "texto", teclado);
	}
	
	/**
	 * Validar la información de los atributos de tipo String con formato de correo electrónico
	 * @param etiqueta Texto para solicitar el atributo
	 * @return Atributo validado
	 */
	public static String atributoCorreo(String etiqueta, Scanner teclado) throws Exception {
		return atributoTexto(etiqueta, "correo", teclado);
	}
	
	/**
	 * Validar la información de los atributos de tipo String
	 * @param etiqueta Texto para solicitar el atributo
	 * @param tipo Tipo de atributo
	 * @return Atributo validado
	 */
	public static String atributoTexto(String etiqueta, String tipo, Scanner teclado) throws Exception {
		String atributo = "";
		
		switch (tipo) {
			case "correo":
				do {
					System.out.print(etiqueta + ": ");
					atributo = teclado.nextLine();
				} while(!correoElectronico(atributo));
				break;
			case "texto":
			default:
				do {
					System.out.print(etiqueta + ": ");
					atributo = teclado.nextLine();
				} while (atributo.equals(""));
				break;
		}
		
		return atributo;
	}
	
	/**
	 * Validar la información de los atributos de tipo Date con formato de fecha
	 * @param etiqueta Texto para solicitar el atributo
	 * @return Atributo validado
	 */
	public static Date atributoFecha(String etiqueta, Scanner teclado) throws Exception {
		return atributoDate(etiqueta, "fecha", teclado);
	}
	
	/**
	 * Validar la información de los atributos de tipo Date con formato de hora
	 * @param etiqueta Texto para solicitar el atributo
	 * @return Atributo validado
	 */
	public static Date atributoHora(String etiqueta, Scanner teclado) throws Exception {
		return atributoDate(etiqueta, "hora", teclado);
	}
	
	/**
	 * Validar la información de los atributos de tipo Date
	 * @param etiqueta Texto para solicitar el atributo
	 * @param tipo Tipo de atributo
	 * @return Atributo validado
	 */
	public static Date atributoDate(String etiqueta, String tipo, Scanner teclado) throws Exception {
		String atributo;
		Date atributoValidado;
		
		switch (tipo) {
			case "hora":
				do {
					System.out.print(etiqueta + ": ");
					atributo = teclado.nextLine();
				} while(!hora(atributo));
				
				atributoValidado = (new SimpleDateFormat("HH:mm")).parse(atributo);
			break;
			case "fecha":
			default:
				do {
					System.out.print(etiqueta + ": ");
					atributo = teclado.nextLine();
				} while(!fecha(atributo));
				
				atributoValidado = (new SimpleDateFormat("dd/MM/yyyy")).parse(atributo);
			break;
		}
		
		return atributoValidado;
	}
	
	/**
	 * Validar la información de los atributos de tipo Double
	 * @param etiqueta Texto para solicitar el atributo
	 * @return Atributo validado
	 */
	public static Double atributoDecimal(String etiqueta, Scanner teclado) throws Exception {
		double atributo = Double.NaN;
		
		do {
			System.out.print(etiqueta + ": ");
			try {
				atributo = Double.parseDouble(teclado.nextLine());
			}
			catch (Exception e) {
				atributo = Double.NaN;
			}
		} while (atributo == Double.NaN);
		
		return atributo;
	}

	/**
	 * Validar la información de los atributos de tipo Integer
	 * @param etiqueta Texto para solicitar el atributo
	 * @return Atributo validado
	 */
	public static Integer atributoEntero(String etiqueta, Scanner teclado) throws Exception {
		int atributo = -1;
		
		do {
			System.out.print(etiqueta + ": ");
			try {
				atributo = Integer.parseInt(teclado.nextLine());
			}
			catch (Exception e) {
				atributo = -1;
			}
		} while (atributo == -1);
		
		return atributo;
	}
	
	/**
	 * Validar que se seleccione una opción entre sí o no
	 * @param etiqueta Texto a mostrar para solicitar sí o no
	 * @return Devuelve verdadero si se selecciona la opción sí, de lo contratio devuelve falso
	 */
	public static boolean opcionSiNo(String etiqueta, Scanner teclado) {
		int opcion = -1;
		
		do {
			System.out.print(etiqueta + "? (1 = sí | 2 = no): ");
			try {
				opcion = Integer.parseInt(teclado.nextLine());
			}
			catch (Exception e) {
				opcion = -1;
			}
		} while (!(opcion == 1 || opcion == 2) || opcion == -1);
		
		if (opcion == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
