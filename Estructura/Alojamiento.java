package Estructura;

import java.util.ArrayList;

import DeComportamiento.Observador.*;
/**
 * Clase abstracta que representa un alojamiento. Contiene atributos comunes a todos los tipos de alojamiento y métodos para obtener información sobre el alojamiento, cambiar su disponibilidad, agregar reviews, etc.
 */
import DeComportamiento.Memento.AlojamientoMemento;

public abstract class Alojamiento{
    protected Lugar lugar;
    protected double precio;
    protected String nombre;
    protected ArrayList<Review> reviews;
    protected Anuncio anuncio;
    public boolean disponible;
    
    /**
     * Cambia el estado de disponibilidad del alojamiento.
     */
    public void cambiarDisponibilidad() {
    	disponible = !disponible;
    }
  

    public Lugar getLugar(){
        return lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double getPrecio();

    public ArrayList<Review> getReviews() {
        return reviews;
    }
    
    public void setPrecio(double p){
    	precio = p;
    	if (anuncio != null) {
            anuncio.notificar();
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    /**
     * Guarda el estado actual en un Memento.
     */
    public AlojamientoMemento save() {
        return new AlojamientoMemento(nombre, precio, disponible, lugar);
    }

    /**
     * Restaura el estado interno desde un Memento (sin notificar automáticamente al anuncio).
     */
    public void restore(AlojamientoMemento memento) {
        if (memento != null) {
            this.nombre = memento.getNombre();
            this.precio = memento.getPrecio();
            this.disponible = memento.isDisponible();
            this.lugar = memento.getLugar();
        }
    }

    /**
     * Obtiene el promedio de las calificaciones
     * @return El promedio de todas las reseñas
     */
    public double getPromedioReviews(){
        if(reviews == null || reviews.isEmpty()) return 0;
        int sum = 0;
        for(Review r : reviews){
            sum += r.nota;
        }
        return (double)sum / reviews.size();
    }

    /**
     * Agrega una reseña a la lista de reseñas del alojamiento
     * @param r Una reseña
     */
    public void agregarReview(Review r){
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(r);
    }
}