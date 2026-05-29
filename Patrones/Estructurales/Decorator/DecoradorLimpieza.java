package Estructurales.Decorator;
import Estructura.Reserva;

public class DecoradorLimpieza extends DecoradorBase {
	
	public DecoradorLimpieza(Reserva w) {
		wrappee = w;
	}
	
	@Override
	public String info() {
		return "Limpieza + "+wrappee.info();
	}
	
}
