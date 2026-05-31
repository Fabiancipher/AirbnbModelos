package Estructurales.Bridge;

/**
 * Representa una notificación de alerta para los huespedes
 */
public class Alerta extends Notificacion {
	
	public Alerta() {
		
	}
	
	public Alerta(String c) {
		contenido = c;
	}
	
	@Override
	public void setContenido(String c) {
		contenido = c;
	}
	
	@Override
	public String getContenido() {
		return "Alerta: "+contenido;
	}
	
}
