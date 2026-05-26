package Estructura;

public class Cabin extends Alojamiento {
	
	public Cabin(double p) {
		precio = p;
	}

	@Override
	public double getPrecio() {
		precio*=1.5;
		return precio;
	}

}
