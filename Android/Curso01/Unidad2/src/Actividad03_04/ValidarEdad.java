package Actividad03_04;

public class ValidarEdad {
	public int edad;
	
	public void setEdad(int edad) {
		if (edad >= 18) {
			this.edad = edad;
			System.out.printf("%d es mayor de edad.\n", edad);
		}
		else {
			System.out.printf("%d es menor de edad.\n", edad);
		}
	}
	
	public int getEdad() {
		return this.edad;
	}
}
