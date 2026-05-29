package Estructurales.Facade;

import DeComportamiento.Cadena.*;
import Estructura.Reserva;

public class FachadaReserva {
	
	public FachadaReserva() {
		
	}
	
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
