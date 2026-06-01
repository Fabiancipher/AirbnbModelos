package DeComportamiento.Cadena;

import Estructura.Reserva;

/**
 * Verifica que el usuario asociado a la reserva sea válido
 */
public class VerificarCliente extends Handler {
	
	public VerificarCliente() {
		
	}
	
	public VerificarCliente(Handler h) {
		next = h;
	}
	
	@Override
	public boolean handle(Reserva r) {
		if(next!=null) {return next.handle(r);}
		return false;
	}
}
