package DeComportamiento.Mediador;

import EntradasSalidas.EntradaConsola;

public class UserHuesped extends User {
	public UserHuesped(String n) {
		nombre = n;
		entrada = new EntradaConsola();
	}
	
	@Override
	public String getNombre() {
		return "Huesped: "+nombre;
	}
	
	@Override
	public String recibir(String c) {
		return "Visto: "+c;
	}
}
