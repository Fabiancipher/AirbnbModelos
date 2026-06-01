package DeComportamiento.Visitante;

import Estructura.*;

public class VisitanteImpuestos implements Visitante {
	public VisitanteImpuestos() {
		
	}
	
	@Override
	public String visitarApartamento(Apartamento a) {
		double impuesto = a.getPrecio()*0.1;
		return a.getNombre()+" tiene un impuesto de: "+impuesto;
	}
	
	@Override
	public String visitarCabina(Cabin a) {
		double impuesto = a.getPrecio()*0.2;
		return a.getNombre()+" tiene un impuesto de: "+impuesto;
	}
}
