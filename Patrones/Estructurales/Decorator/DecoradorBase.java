package Estructurales.Decorator;

import Estructura.*;

public abstract class DecoradorBase implements Reserva {
	protected Reserva wrappee;
	
	@Override
	public Alojamiento getAlojamiento() {
		return wrappee.getAlojamiento();
	}
	
	@Override
	public Experiencia getExperiencia() {
		return wrappee.getExperiencia();
	}
	
	@Override
	public Servicio getServicio() {
		return wrappee.getServicio();
	}
	
	@Override
	public Lugar getDestino() {
		return wrappee.getDestino();
	}
	
	@Override
	public String info() {
		return wrappee.info();
	}
}
