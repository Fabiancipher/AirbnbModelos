package Estructura;

public class Masaje extends Servicio {
	public Masaje(String n) {
		nombre = n;
	}
	
	@Override
	public String toString() {
		return "Masaje: "+nombre;
	}
}
