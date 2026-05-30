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
		if(next!=null) {
			if(!r.getAlojamiento().disponible) {return false;}
			return next.handle(r);
		}
		return false;
	}
}