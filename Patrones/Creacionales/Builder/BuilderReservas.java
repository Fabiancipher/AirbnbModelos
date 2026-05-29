package Creacionales.Builder;

import Estructura.*;

public class BuilderReservas extends Builder {
	
	@Override
	public Reserva getReserva() {
		return new ReservaBase(alojo, servicio, experiencia, destino);
	}
	
}
