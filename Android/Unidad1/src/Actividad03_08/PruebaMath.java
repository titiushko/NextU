package Actividad03_08;

public class PruebaMath {
	public static void main(String[] args) {
		double a = 50;	//longitud
		double R = 25;	//radio
		double h = 150;	//altura
		
		System.out.printf("Volumen de un cubo de longitud %.2f: %.2f\n", a, Math.pow(a, 3));
		System.out.printf("Volumen de un cilindro de radio %.2f y altura %.2f: %.2f", R, h, (Math.PI * Math.pow(R, 2) * h));
	}
}