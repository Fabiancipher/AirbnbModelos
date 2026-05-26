package Estructura;

public class Apartamento extends Alojamiento {
	
	public Apartamento(double precio) {
		this.precio = precio;
	}

	@Override
	public double getPrecio() {
		precio *=1.2;
		return precio;
	}

}
