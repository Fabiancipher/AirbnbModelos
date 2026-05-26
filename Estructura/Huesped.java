package Estructura;

import java.util.HashMap;

public class Huesped extends Usuario {
	
	public HashMap<String, Anuncio> favoritos;

	@Override
	public void realizarPago() {
		
	}

	@Override
	public Boolean verificar() {
		return true;
	}
	
	public void addFavorito(Anuncio a) {
		favoritos.put(a.publicitado.getNombre(), a);
	}
	
	public void removeFavorito(Anuncio a) {
		favoritos.remove(a.publicitado.getNombre());
	}
	
	public void update(Anuncio a) {
		Anuncio actualizar = favoritos.get(a.publicitado.getNombre());
		if(actualizar==null){
			System.out.println(nombre+" no está suscrito a tal anuncio");
			return;
		}
		favoritos.put(a.publicitado.getNombre(), a);
	}

}
