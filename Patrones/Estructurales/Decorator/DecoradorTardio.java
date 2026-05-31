package Estructurales.Decorator;
import Estructura.Reserva;

/**
 * Añade una "tarifa" por un checkout tardio
 */
public class DecoradorTardio extends DecoradorBase {
	
	public DecoradorTardio(Reserva w) {
		wrappee = w;
	}
	
	@Override
	public String toString() {
		return "Tardio + "+wrappee.toString();
	}
	
}
