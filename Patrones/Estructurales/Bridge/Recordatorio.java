package Estructurales.Bridge;

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
