package Estructura;

import java.util.ArrayList;

public class Anuncio implements Clonable {
	public Alojamiento publicitado;
	public ArrayList<Huesped> suscritos;
	
	public Anuncio(Alojamiento p) {
		publicitado = p;
		suscritos = new ArrayList<>();
	}
	
	public void addSuscriptor(Huesped h){
		suscritos.add(h);
	}
	
	public void removeSuscriptor(Huesped h) {
		suscritos.remove(h);
	}
	
	public void notificar(){
		for(Huesped h : suscritos) {
			h.update(this);
		}
	}
	
	@Override
	public Clonable clonar(){
		return new Anuncio(publicitado);
	}
}
