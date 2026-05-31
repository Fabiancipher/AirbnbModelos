package DeComportamiento.Observador;

import java.util.HashMap;

/**
 * Representa a los usuarios que viajan. Contiene campos para su nombre y sus anuncios marcados como favoritos
 */
public class Huesped{
	
	private final String nombre;
	private HashMap<String, Anuncio> favoritos;
	
	public Huesped(String n) {
		nombre = n;
		favoritos = new HashMap<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Añade un anuncio a su lista de favoritos
	 * @param a Un anuncio
	 */
	public void addFavorito(Anuncio a) {
		favoritos.put(a.publicitado.getNombre(), a);
		a.addSuscriptor(this);
	}
	
	/**
	 * Remueve un anuncio de su lista de favoritos
	 * @param a El anuncio en cuestión
	 */
	public void removeFavorito(Anuncio a) {
		favoritos.remove(a.publicitado.getNombre());
	}
	
	/**
	 * Actualiza el estado del anuncio en cuestión. Esto, en la práctica, cambia el estado que tiene el huesped del alojamiento
	 * @param a Un anuncio
	 */
	public void update(Anuncio a) {
		Anuncio actualizar = favoritos.get(a.publicitado.getNombre());
		if(actualizar==null){
			System.out.println(nombre+" no está suscrito a tal anuncio");
			return;
		}
		favoritos.put(a.publicitado.getNombre(), a);
		System.out.println(a + " fue actualizado");
	}
	
	@Override
	public String toString() {
		return "Huesped: "+nombre;
	}

}
