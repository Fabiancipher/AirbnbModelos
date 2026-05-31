package Estructura;

public class Cultural extends Experiencia {
	public Cultural(String n) {
		nombre = n;
	}
	
	@Override
	public String toString() {
		return "Experiencia Cultural: "+nombre;
	}
}
