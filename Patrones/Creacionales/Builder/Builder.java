package Creacionales.Builder;

import Estructura.*;
/**
 * Representa a un constructor de Reservas
 * <p>
 * Contiene operaciones comunes a cualquier constructor de reservas
 */
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
	
	/**
	 * Verifica si alguno de los campos es nulo. Antes de obtener el objeto, debería llamarse esta función
	 * <p>
	 * En caso de añadir más campos a los demás Builders, este método debería sobre-escribirse
	 * @return True si alguno de los campos es nulo
	 */
	public boolean verificar() {
		return (alojo == null || destino == null || servicio == null || experiencia == null);
	}
	
	/**
	 * Crea una reserva de algún tipo partícular
	 * @return Una reserva
	 */
	public abstract Reserva getReserva();
}
