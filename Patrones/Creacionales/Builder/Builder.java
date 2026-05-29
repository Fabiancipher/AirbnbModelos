package Creacionales.Builder;

import Estructura.*;
public abstract class Builder {
	protected Alojamiento alojo;
	protected Lugar destino;
	protected Servicio servicio;
	protected Experiencia experiencia;
	
	public void setAlojo(Alojamiento a) {
		alojo = a;
	}
	
	public void setLugar(Lugar l) {
		destino = l;
	}
	
	public void setServicio(Servicio s) {
		servicio = s;
	}
	
	public void setExperiencia(Experiencia e) {
		experiencia = e;
	}
	
	public boolean verificar() {
		if(alojo == null || destino == null || servicio == null || experiencia == null) {
			return false;
		}
		return true;
	}
	
	public abstract Reserva getReserva();
}
