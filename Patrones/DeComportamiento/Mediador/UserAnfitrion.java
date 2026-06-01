package DeComportamiento.Mediador;

import EntradasSalidas.EntradaConsola;

public class UserAnfitrion extends User {
	public UserAnfitrion() {
		nombre = "Anfitrion";
		entrada = new EntradaConsola();
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String recibir(String c) {
		return "Visto: "+c;
	}
}
