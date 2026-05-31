package Estructurales.Decorator;
import Estructura.Reserva;

/**
 * Añade una "tarifa" por llevar mascotas
 */
public class DecoradorMascotas extends DecoradorBase {
	
	public DecoradorMascotas(Reserva w) {
		wrappee = w;
	}
	
	@Override
	public String toString() {
		return "Mascotas + "+wrappee.toString();
	}
	
}
