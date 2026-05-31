package DeComportamiento.Cadena;

import Estructura.Reserva;

/**
 * Verifica que sea posible realizar el pago de la reserva
 */
public class VerificarPago extends Handler {
	
	public VerificarPago() {
		
	}
	
	public VerificarPago(Handler h) {
		next = h;
	}
	
	@Override
	public boolean handle(Reserva r) {
		// TODO: Que haga algo antes de. Podría arrojar falso si, e.g: Cliente.pago.fondos < Alojamiento.precio
		if(next!=null) {return next.handle(r);}
		return false;
	}
}