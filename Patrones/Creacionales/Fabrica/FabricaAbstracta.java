package Creacionales.Fabrica;

import Estructura.*;
/**
 * Representa a un objeto capaz de crear familias de objeto
 */
public interface FabricaAbstracta {
	/**
	 * Crea un alojamiento de algún tipo particular
	 * @param p El precio del alojamiento
	 * @return Un alojamiento
	 */
	public Alojamiento crearAlojamiento(double p);
	/**
	 * Crea una experiencia de algún tipo particular
	 * @param n El nombre de la experiencia
	 * @return Una experiencia
	 */
	public Experiencia crearExperiencia(String n);
	/**
	 * Crea un servicio de algún tipo particular
	 * @param n El nombre del servicio
	 * @return Un servicio
	 */
	public Servicio crearServicio(String n);
}
