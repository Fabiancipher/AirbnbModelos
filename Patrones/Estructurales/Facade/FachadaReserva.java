package Estructurales.Facade;

import DeComportamiento.Cadena.*;
import Estructura.Reserva;

/**
 * Realiza el proceso de verificar una reserva 
 * <p>
 * Simplifica la cadena de verificación
 * @see 
 * Cadena
 */
public class FachadaReserva {
	
	public FachadaReserva() {
		
	}
	
	/**
	 * Realiza todos los pasos necesarios para verificar una reserva
	 * @param r La reserva a verificar
	 * @return
	 */
	public boolean reservar(Reserva r) {
		Handler vCliente = new VerificarCliente();
		Handler vDisponibilidad = new VerificarDisponibilidad();
		Handler vPago = new VerificarPago();
		Handler aceptar = new Aceptar();
		
		vCliente.setNext(vDisponibilidad);
		vDisponibilidad.setNext(vPago);
		vPago.setNext(aceptar);
		
		return vCliente.handle(r);
	}
}
