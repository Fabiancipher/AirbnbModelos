package Estructura;

import java.text.DecimalFormat;

import DeComportamiento.Visitante.Visitante;

public class Cabin extends Alojamiento {
	
	public Cabin(double p) {
		precio = p;
	}

	@Override
	public double getPrecio() {
		return precio*1.5;
	}
	
	@Override
	public String aceptar(Visitante v) {
		return v.visitarCabina(this);
	}
	
	@Override
	public String toString() {
		return "Cabina || Precio: "+new DecimalFormat("#.##").format(getPrecio())+" , Promedio Reseñas: "+new DecimalFormat("#.##").format(getPromedioReviews());
	}

}
