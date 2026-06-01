package DeComportamiento.Iterador;

import Estructura.Alojamiento;

/**
 * Interfaz comun a cualquier iterador que interactue con una lista de alojamientos
 */
public interface IteradorAlojamientos {
	/**
	 * Revisa si hay un siguiente objeto en la lista
	 * Lo que se considera "siguiente" depende del iterador concreto
	 * @return Un booleano. Para mejores practicas: True si hay un siguiente objeto
	 */
	public boolean hasNext();
	/**
	 * Retorna un alojamiento. El como y que se obtiene depende del iterador concreto
	 * @return Un alojamiento
	 */
	public Alojamiento getNext();
	/**
	 * Si el iterador implementa un indice, este método debería devolverlo a su estado por defecto
	 *<p>
	 *Este método debería llamarse cada vez que se desea recorrer la lista desde el principio
	 */
	public void reset();
}
