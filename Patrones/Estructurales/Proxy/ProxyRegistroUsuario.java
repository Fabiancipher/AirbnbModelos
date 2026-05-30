package Estructurales.Proxy;

import DeComportamiento.Observador.Huesped;
import EntradasSalidas.Salida;

public class ProxyRegistroUsuario implements Registro {
	
	private RegistroUsuario servicio;
	private Salida salida;
	
	public ProxyRegistroUsuario(Salida s) {
		salida = s;
	}
	
	@Override
	public void addUsuario(Huesped h) {
		if(h.getNombre().length()>50) {
			salida.enviar("Nombre demasiado largo");
			return;
		}
		servicio = new RegistroUsuario();
		servicio.addUsuario(h);
	}
	
}
