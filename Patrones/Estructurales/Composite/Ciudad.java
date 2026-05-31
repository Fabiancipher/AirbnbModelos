package Estructurales.Composite;

import Estructura.Lugar;
import java.util.ArrayList;

/**
 * Representa una ciudad. Se le pueden añadir barrios o direcciones
 */
public class Ciudad extends Lugar {
	private ArrayList<Lugar> hijos;
	
	public Ciudad(String n) {
		nombre = n;
		hijos = new ArrayList<>();
	}
	
	@Override
	public void add(Lugar a) {
		if(a instanceof Ciudad || a instanceof Pais) {
			System.out.println("No se puede añadir una ciudad a una ciudad, o un pais a una ciudad");
			return;
		}
		hijos.add(a);
	}
	
	@Override
	public void remove(Lugar a) {
		hijos.remove(a);
	}
	
	@Override
	public String getNombre(){
		StringBuilder sb = new StringBuilder();
		sb.append(nombre).append(": { ");
		if(hijos.isEmpty()){sb.append(" }");}
		for(Lugar l : hijos) {
			sb.append(l.getNombre());
			if(!l.equals(hijos.getLast())){
				sb.append(", ");
			}
			else{
				sb.append(" }");
			}
		}
		return sb.toString();
	}
}
