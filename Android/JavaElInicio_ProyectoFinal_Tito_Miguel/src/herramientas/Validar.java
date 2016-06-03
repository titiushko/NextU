package herramientas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
}
