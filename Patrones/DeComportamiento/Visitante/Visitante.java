package DeComportamiento.Visitante;

import Estructura.*;
/**
 * Interfaz para visitantes de alojamientos
 */
public interface Visitante {
	/**
	 * "Visita" a un apartamento
	 * @param a Un apartamento
	 * @return Datos del apartamento
	 */
	public String visitarApartamento(Apartamento a);
	/**
	 * "Visita" una cabina
	 * @param a Una cabina
	 * @return Datos de la cabina
	 */
	public String visitarCabina(Cabin a);
}
