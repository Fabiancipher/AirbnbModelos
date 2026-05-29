package Estructurales.Decorator;
import Estructura.Reserva;

public class DecoradorTardio extends DecoradorBase {
	
	public DecoradorTardio(Reserva w) {
		wrappee = w;
	}
	
	@Override
	public String info() {
		return "Tardio + "+wrappee.info();
	}
	
}
