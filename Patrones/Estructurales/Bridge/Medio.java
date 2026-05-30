package Estructurales.Bridge;

public abstract class Medio {
	protected Notificacion noti;
	
	public void setNoti(Notificacion n) {
		noti = n;
	}
	
	public abstract void enviar();
}
