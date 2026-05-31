package Creacionales.Prototipo;

/**
 * Representa objetos que se pueden clonar.
 * <p>
 * Si se quiere obtener un clon, tanto el objeto original como el clon deben ser declarados como "Clonable"
 */
public interface Clonable {
	/**
	 * Crea una copia profunda del objeto
	 * @return Un clonable. Particularmente el mismo objeto que llamó esta operación
	 */
	public Clonable clonar();
}
