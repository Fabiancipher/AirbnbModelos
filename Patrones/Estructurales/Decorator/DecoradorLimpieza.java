package Estructurales.Decorator;
import Estructura.Reserva;

/**
 * Añade una "tarifa" de limpieza
 */
public class DecoradorLimpieza extends DecoradorBase {
	
	public DecoradorLimpieza(Reserva w) {
		wrappee = w;
	}
	
	@Override
	public String toString() {
		return "Limpieza + "+wrappee.toString();
	}
	
}
