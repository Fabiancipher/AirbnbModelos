package Estructura;

public class Cabin extends Alojamiento {
	
	public Cabin(double p) {
		precio = p;
	}

	@Override
	public double getPrecio() {
		return precio*1.5;
	}
	
	@Override
	public String toString() {
		return "Cabina || Precio: "+getPrecio();
	}

}
