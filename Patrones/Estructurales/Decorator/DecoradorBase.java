package Estructurales.Decorator;

import Estructura.*;

/**
 * Da las operaciones comunes para los demás decoradores
 */
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
	public abstract String toString();
}
