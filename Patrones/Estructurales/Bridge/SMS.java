package Estructurales.Bridge;

import EntradasSalidas.SalidaConsola;

/**
 * Representa un canal de mensajes de texto
 */
public class SMS extends Medio{
	
	private final SalidaConsola salida;
	
	public SMS() {
		salida = new SalidaConsola();
	}
	
	public SMS(Notificacion n) {
		salida = new SalidaConsola();
		noti = n;
	}
	
	
	@Override
	public void enviar() {
		salida.enviar("SMS: "+noti.getContenido());
	}
	
}
