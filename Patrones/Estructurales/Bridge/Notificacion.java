package Estructurales.Bridge;

/**
 * Representa una notificacion abstracta. Posee un campo para el contenido de la notificacion
 */
public abstract class Notificacion {
	protected String contenido;
	
	public abstract String getContenido();
	public abstract void setContenido(String c);
}
