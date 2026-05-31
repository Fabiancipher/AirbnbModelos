package DeComportamiento.Observador;

import java.util.ArrayList;

import Estructura.Alojamiento;
import Creacionales.Prototipo.*;

/**
 * Representa un anuncio de un alojamiento
 * <p>
 * Posee campos para el alojamiento en cuestión y una lista de usuarios "interesados" en él
 */
public class Anuncio implements Clonable {
	public Alojamiento publicitado;
	public ArrayList<Huesped> suscritos;
	
	public Anuncio(Alojamiento p) {
		publicitado = p;
		suscritos = new ArrayList<>();
	}
	
	/**
	 * Añade un huesped interesado
	 * @param h Un huesped
	 */
	public void addSuscriptor(Huesped h){
		suscritos.add(h);
	}
	
	/**
	 * Remueve un huesped que perdió el interes
	 * @param h Un huesped
	 */
	public void removeSuscriptor(Huesped h) {
		suscritos.remove(h);
	}
	
	/**
	 * Avisa de sus propios cambios a los interesados. No avisa cambios en el alojamiento publicitado
	 */
	public void notificar(){
		for(Huesped h : suscritos) {
			h.update(this);
		}
	}
	
	@Override
	public Clonable clonar(){
		return new Anuncio(publicitado);
	}
	
	@Override
	public String toString() {
		return "Anuncio: "+publicitado.toString();
	}
}
