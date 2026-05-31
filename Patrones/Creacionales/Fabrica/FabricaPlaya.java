package Creacionales.Fabrica;

import Estructura.*;
/**
 * Crea "planes" para la playa
 */
public class FabricaPlaya implements FabricaAbstracta {

	/**
	 * Crea cabinas
	 */
	@Override
	public Alojamiento crearAlojamiento(double p) {
		return new Cabin(p);
	}

	/**
	 * Crea experiencias de entrenamiento
	 */
	@Override
	public Experiencia crearExperiencia(String n) {
		return new Entrenamiento(n);
	}

	/**
	 * Crea servicios de masaje
	 */
	@Override
	public Servicio crearServicio(String n) {
		return new Masaje(n);
	}

}
