package Estructurales.Bridge;

/**
 * Representa los recordatorios de fechas o similares que les llegan a los huespedes
 */
public class Recordatorio extends Notificacion {
	
	public Recordatorio() {
		
	}
	
	public Recordatorio(String c) {
		contenido = c;
	}
	
	@Override
	public void setContenido(String c) {
		contenido = c;
	}
	
	@Override
	public String getContenido() {
		return "Recordatorio: "+contenido;
	}
	
}
