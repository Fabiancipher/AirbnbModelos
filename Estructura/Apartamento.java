package Estructura;

import java.text.DecimalFormat;

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
		return "Apartamento || Precio: "+new DecimalFormat("#.##").format(getPrecio())+" , Promedio Reseñas: "+new DecimalFormat("#.##").format(getPromedioReviews());
	}

}
