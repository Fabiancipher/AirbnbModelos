package Estructura;
/**
 * Representa a una reserva. Esta interfaz se utiliza para decorar a la clase ReservaBase
 * @see ReservaBase
 */
public interface Reserva {
	@Override
	public String toString();
	public Alojamiento getAlojamiento();
	public Experiencia getExperiencia();
	public Servicio getServicio();
	public Lugar getDestino();
}
