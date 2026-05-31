package Estructurales.Bridge;

import EntradasSalidas.SalidaConsola;

/**
 * Representa un canal para los mensajes enviados por email
 */
public class Correo extends Medio{
	
	private final SalidaConsola salida;
	
	public Correo() {
		salida = new SalidaConsola();
	}
	
	public Correo(Notificacion n) {
		salida = new SalidaConsola();
		noti = n;
	}
	
	
	@Override
	public void enviar() {
		salida.enviar("Correo: "+noti.getContenido());
	}
	
}