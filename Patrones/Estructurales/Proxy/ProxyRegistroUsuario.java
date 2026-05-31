package Estructurales.Proxy;

import DeComportamiento.Observador.Huesped;
import EntradasSalidas.Salida;
import EntradasSalidas.SalidaConsola;

/**
 * Intermediario entre el registro real y el usuario
 * <p>
 * Contiene dos constructores. Si no se especifica el registro, esta clase puede generar uno propio. Sin embargo, esto fuerza a usar únicamente este proxy para acceder a dicho registro
 * <p>
 * Esencialmente, no serían intercambiables
 */
public class ProxyRegistroUsuario implements Registro {
	
	private Registro servicio;
	private Salida salida;
	
	public ProxyRegistroUsuario(Registro r) { n
		servicio = r;
		salida = new SalidaConsola();
	}
	
	public ProxyRegistroUsuario() {
		salida = new SalidaConsola();
	}
	
	@Override
	public void addUsuario(Huesped h) {
		if(h.getNombre().length()>50) {
			salida.enviar("Nombre demasiado largo");
			return;
		}
		if(servicio==null) {
			servicio = new RegistroUsuario();
		}
		servicio.addUsuario(h);
	}
	
	@Override
	public String getUsuarios() {
		return servicio.getUsuarios();
	}
}
