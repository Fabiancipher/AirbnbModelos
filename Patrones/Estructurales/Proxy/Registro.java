package Estructurales.Proxy;

import DeComportamiento.Observador.Huesped;

/**
 * Representa un registro de usuarios
 */
public interface Registro {
	/**
	 * Añade un huesped a la lista
	 * @param h Un huesped
	 */
	public void addUsuario(Huesped h);
	/**
	 * Obtiene, de alguna forma, los datos de los usuarios
	 * @return Datos de los usuarios
	 */
	public String getUsuarios();
}
