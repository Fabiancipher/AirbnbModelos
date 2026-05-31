package DeComportamiento.Cadena;

import Estructura.Reserva;
/**
 * Representación abstracta de un eslabón en una cadena. Contiene un campo para el siguiente eslabon
 */
public abstract class Handler {
	protected Handler next = null;
	
	public void setNext(Handler h) {
		next = h;
	}
	/**
	 * "Maneja" la reserva asignada
	 * @param r La reserva a verificar
	 * @return True Si la operacion fue exitosa
	 */
	public abstract boolean handle(Reserva r);
}
