package Creacionales.Fabrica;

import Estructura.*;

public class FabricaCiudad implements FabricaAbstracta {

	@Override
	public Alojamiento crearAlojamiento(double p) {
		return new Apartamento(p);
	}

	@Override
	public Experiencia crearExperiencia() {
		return new Cultural();
	}

	@Override
	public Servicio crearServicio() {
		return new Fotografia();
	}

}
