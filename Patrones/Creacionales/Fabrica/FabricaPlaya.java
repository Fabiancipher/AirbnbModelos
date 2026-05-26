package Creacionales.Fabrica;

import Estructura.*;

public class FabricaPlaya implements FabricaAbstracta {

	@Override
	public Alojamiento crearAlojamiento(double p) {
		return new Cabin(p);
	}

	@Override
	public Experiencia crearExperiencia() {
		return new Entrenamiento();
	}

	@Override
	public Servicio crearServicio() {
		return new Masaje();
	}

}
