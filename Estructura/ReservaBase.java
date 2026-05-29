package Estructura;

public class ReservaBase implements Reserva {
	
	public Alojamiento alojo;
	public Lugar destino;
	public Servicio servicio;
	public Experiencia experiencia;
	
	public ReservaBase(Alojamiento alo, Servicio ser, Experiencia exp, Lugar d) {
		alojo = alo;
		servicio = ser;
		experiencia = exp;
		destino = d;
	}
	
	@Override
	public String info() {
		return "Reserva";
	}
	
}
