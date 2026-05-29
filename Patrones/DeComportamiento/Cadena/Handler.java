package DeComportamiento.Cadena;

import Estructura.Reserva;

public abstract class Handler {
	protected Handler next = null;
	
	public void setNext(Handler h) {
		next = h;
	}
	
	public abstract boolean handle(Reserva r);
}
