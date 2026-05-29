package DeComportamiento.Cadena;

import Estructura.Reserva;

public class VerificarDisponibilidad extends Handler {
	
	public VerificarDisponibilidad() {
		
	}
	
	public VerificarDisponibilidad(Handler h) {
		next = h;
	}
	
	@Override
	public boolean handle(Reserva r) {
		// TODO: Que haga algo antes de. Podría arrojar falso si, e.g: Alojamiento.disponible = false
		if(next!=null) {return next.handle(r);}
		return false;
	}
}