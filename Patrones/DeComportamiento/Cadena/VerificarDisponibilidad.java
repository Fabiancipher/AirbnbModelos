package DeComportamiento.Cadena;

import Estructura.Reserva;

/**
 * Verifica que el alojamiento asociado a la reserva esté disponible
 */
public class VerificarDisponibilidad extends Handler {
	
	public VerificarDisponibilidad() {
		
	}
	
	public VerificarDisponibilidad(Handler h) {
		next = h;
	}
	
	@Override
	public boolean handle(Reserva r) {
		if(next!=null) {
			if(!r.getAlojamiento().disponible) {return false;}
			return next.handle(r);
		}
		return false;
	}
}