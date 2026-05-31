package Creacionales.Builder;

import Estructura.*;
/**
 * Construye reservas basicas
 */
public class BuilderReservas extends Builder {
	
	@Override
	public Reserva getReserva() {
		return new ReservaBase(alojo, servicio, experiencia, destino);
	}
	
}
