package Estructurales.Proxy;

import java.util.ArrayList;

import Estructura.Huesped;

public class RegistroUsuario implements Registro {
	
	private final ArrayList<Huesped> huespedes;
	
	public RegistroUsuario() {
		huespedes = new ArrayList<>();
	}
	
	@Override
	public void addUsuario(Huesped h) {
		huespedes.add(h);
	}
	
}
