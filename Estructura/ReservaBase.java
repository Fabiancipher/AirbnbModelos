package Estructura;

public class ReservaBase implements Reserva {
	
	private Alojamiento alojo;
	private Lugar destino;
	private Servicio servicio;
	private Experiencia experiencia;
	
	public ReservaBase(Alojamiento alo, Servicio ser, Experiencia exp, Lugar d) {
		alojo = alo;
		servicio = ser;
		experiencia = exp;
		destino = d;
	}
	
	@Override
	public Alojamiento getAlojamiento() {
		return alojo;
	}
	
	@Override
	public Experiencia getExperiencia() {
		return experiencia;
	}
	
	@Override
	public Servicio getServicio() {
		return servicio;
	}
	
	@Override
	public Lugar getDestino() {
		return destino;
	}
	
	@Override
	public String info() {
		return "Reserva";
	}
	
}
