package Estructurales.Composite;

import Estructura.Lugar;
import java.util.ArrayList;

public class Pais extends Lugar {
	private ArrayList<Lugar> hijos;
	
	public Pais(String n) {
		nombre = n;
		hijos = new ArrayList<>();
	}
	
	@Override
	public void add(Lugar a) {
		if(a instanceof Pais) {
			System.out.println("No se puede añadir un pais a un pais");
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
			sb.append(l.getNombre());
			if(!l.equals(hijos.getLast())) {
				sb.append(", ");
			}
			else {
				sb.append(".");
			}
		}
		return sb.toString();
	}
}
