package DeComportamiento.Cadena;

import Estructura.Reserva;

public class VerificarCliente extends Handler {
	
	public VerificarCliente() {
		
	}
	
	public VerificarCliente(Handler h) {
		next = h;
	}
	
	@Override
	public boolean handle(Reserva r) {
		// TODO: Que haga algo antes de. Podría arrojar falso si, e.g: Busca en la BD y no encuentra al usuario
		if(next!=null) {return next.handle(r);}
		return false;
	}
}
