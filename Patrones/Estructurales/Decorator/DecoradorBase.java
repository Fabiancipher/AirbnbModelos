package Estructurales.Decorator;
import Estructura.Reserva;

public abstract class DecoradorBase implements Reserva {
	protected Reserva wrappee;
	
	@Override
	public String info() {
		return wrappee.info();
	}
}
