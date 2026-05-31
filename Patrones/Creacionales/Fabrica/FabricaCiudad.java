package Creacionales.Fabrica;

import Estructura.*;

/**
 * Crea "planes" para las ciudades
 */
public class FabricaCiudad implements FabricaAbstracta {

	/**
	 * Crea apartamentos
	 */
	@Override
	public Alojamiento crearAlojamiento(double p) {
		return new Apartamento(p);
	}

	/**
	 * Crea experiencias culturales
	 */
	@Override
	public Experiencia crearExperiencia(String n) {
		return new Cultural(n);
	}

	/**
	 * Crea servicios de fotografia
	 */
	@Override
	public Servicio crearServicio(String n) {
		return new Fotografia(n);
	}

}
