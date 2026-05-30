package Estructurales.Bridge;

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
