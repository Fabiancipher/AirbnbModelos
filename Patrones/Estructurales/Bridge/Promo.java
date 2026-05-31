package Estructurales.Bridge;

/**
 * Representa las distintas promociones que le llegan a los usuarios
 */
public class Promo extends Notificacion {
	
	public Promo() {
		
	}
	
	public Promo(String c) {
		contenido = c;
	}
	
	@Override
	public void setContenido(String c) {
		contenido = c;
	}
	
	@Override
	public String getContenido() {
		return "Promocion: "+contenido;
	}
	
}