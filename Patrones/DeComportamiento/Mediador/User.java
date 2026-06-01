package DeComportamiento.Mediador;

import EntradasSalidas.EntradaConsola;

public abstract class User {
	
	protected String nombre;
	protected Mediador mediador;
	protected EntradaConsola entrada;
	
	public void enviar(String nombre) {
		mediador.enviarMensaje(nombre, entrada.capturar());
	}
	
	public void setMediador(Mediador m) {
		mediador = m;
	}
	
	public abstract String recibir(String m);
	public abstract String getNombre();
}
