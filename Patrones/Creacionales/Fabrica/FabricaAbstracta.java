package Creacionales.Fabrica;

import Estructura.*;

public interface FabricaAbstracta {
	public Alojamiento crearAlojamiento(double p);
	public Experiencia crearExperiencia();
	public Servicio crearServicio();
}
