package DeComportamiento.Memento;

import Estructura.Lugar;

/**
 * Memento que almacena el estado interno de un Alojamiento.
 * Es inmutable para garantizar la integridad de los datos guardados.
 */
public class AlojamientoMemento {
    private final String nombre;
    private final double precio;
    private final boolean disponible;
    private final Lugar lugar;

    public AlojamientoMemento(String nombre, double precio, boolean disponible, Lugar lugar) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.lugar = lugar;
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

}
