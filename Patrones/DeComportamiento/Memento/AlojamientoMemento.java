package DeComportamiento.Memento;

import Estructura.Lugar;
import Estructura.Tipo;
import Estructura.Espacio;

/**
 * Memento que almacena el estado interno de un Alojamiento.
 * Es inmutable para garantizar la integridad de los datos guardados.
 */
public class AlojamientoMemento {
    private final String nombre;
    private final double precio;
    private final boolean disponible;
    private final Lugar lugar;
    private final Tipo tipo;
    private final Espacio espacio;

    public AlojamientoMemento(String nombre, double precio, boolean disponible, Lugar lugar, Tipo tipo, Espacio espacio) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.lugar = lugar;
        this.tipo = tipo;
        this.espacio = espacio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Espacio getEspacio() {
        return espacio;
    }
}
