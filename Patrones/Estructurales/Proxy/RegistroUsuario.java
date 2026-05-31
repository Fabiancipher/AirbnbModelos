package Estructurales.Proxy;

import DeComportamiento.Observador.Huesped;
import java.util.ArrayList;

/**
 * Clase concreta de "Registro". Posee un campo para la lista de huespedes
 */
public class RegistroUsuario implements Registro {
	
	private final ArrayList<Huesped> huespedes;
	
	public RegistroUsuario() {
		huespedes = new ArrayList<>();
	}
	
	@Override
	public void addUsuario(Huesped h) {
		huespedes.add(h);
	}
	
	@Override
	public String getUsuarios() {
		StringBuilder sb = new StringBuilder();
		for(Huesped h: huespedes) {
			sb.append(h);
			if(!h.equals(huespedes.getLast())) {
				sb.append(" || ");
			}
		}
		return sb.toString();
	}
	
}
