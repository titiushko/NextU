package Actividad02_02;

public class Vehiculo {
	public String modelo;
	public String placa;
	public String motor;
	
	public Vehiculo(String modelo, String placa, String motor) {
		this.modelo = modelo;
		this.placa = placa;
		this.motor = motor;
	}
	
	public void imprimirVehiculo() {
		System.out.printf("Modelo: %s\nPlaca: %s\nMotor: %s\n", this.modelo, this.placa, this.motor);
	}
}