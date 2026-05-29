package Estructurales.Decorator;
import Estructura.Reserva;

public class DecoradorMascotas extends DecoradorBase {
	
	public DecoradorMascotas(Reserva w) {
		wrappee = w;
	}
	
	@Override
	public String info() {
		return "Mascotas + "+wrappee.info();
	}
	
}
