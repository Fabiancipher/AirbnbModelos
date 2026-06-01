package DeComportamiento.Iterador;

import Creacionales.Singleton.*;
import Estructura.Alojamiento;

public class IteradorDescendente implements IteradorAlojamientos {
	private int posicionActual;
	private final ListaAlojamientos usuario;
	
	public IteradorDescendente(ListaAlojamientos objetivo) {
		usuario = objetivo;
		posicionActual = objetivo.getSize();
	}
	
	@Override
	public boolean hasNext() {
		return posicionActual>0;
	}
	
	@Override
	public Alojamiento getNext() {
		if(!hasNext()) {
			return null;
		}
		posicionActual--;
		return usuario.getAlojamiento(posicionActual);
	}
	
	/**
	 * Este método debe llamarse manualmente. Este iterador no se reinicia por cuenta propia
	 */
	@Override
	public void reset() {
		posicionActual = usuario.getSize();
	}
}
