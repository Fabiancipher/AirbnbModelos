package Estructura;

public class Entrenamiento extends Experiencia {
	public Entrenamiento(String n) {
		nombre = n;
	}
	
	@Override
	public String toString() {
		return "Experiencia Entrenamiento: "+nombre;
	}
}
