package Estructurales.Bridge;

/**
 * Representa un medio, por el cual se envian las distintas notificaciones
 * <p>
 * Posee un campo para la notificacion en cuestión
 */
public abstract class Medio {
	protected Notificacion noti;
	
	public void setNoti(Notificacion n) {
		noti = n;
	}
	
	public abstract void enviar();
}
