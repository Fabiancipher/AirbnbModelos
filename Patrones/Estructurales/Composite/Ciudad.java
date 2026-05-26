package Estructurales.Composite;

import Estructura.Lugar;
import java.util.ArrayList;

public class Ciudad extends Lugar {
	private ArrayList<Lugar> hijos;
	
	public Ciudad(String n) {
		nombre = n;
		hijos = new ArrayList<>();
	}
	
	@Override
	public void add(Lugar a) {
		if(a instanceof Ciudad) {
			System.out.println("No se puede añadir una ciudad a una ciudad");
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
		sb.append(nombre).append(", ");
		for(Lugar l : hijos) {
			sb.append(l.getNombre()).append(", ");
		}
		return sb.toString();
	}
}
