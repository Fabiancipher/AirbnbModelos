package Estructura;

public class Apartamento extends Alojamiento {
	
	public Apartamento(double precio) {
		this.precio = precio;
		disponible = true;
	}

	@Override
	public double getPrecio() {
		return precio*1.2;
	}
	
	@Override
	public String toString() {
		return "Apartamento || Precio: "+getPrecio();
	}

}
