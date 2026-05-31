package DeComportamiento.Cadena;

import Estructura.Reserva;

/**
 * La última parte de la cadena. Si se llega a esta, se asume que la operación fue exitosa
 */
public class Aceptar extends Handler {
	
	public Aceptar() {
		
	}
	
	
	@Override
	public boolean handle(Reserva r) {
		return true;
	}
}
