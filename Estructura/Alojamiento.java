package Estructura;

import java.util.ArrayList;

import DeComportamiento.Observador.*;
/**
 * Clase abstracta que representa un alojamiento. Contiene atributos comunes a todos los tipos de alojamiento y métodos para obtener información sobre el alojamiento, cambiar su disponibilidad, agregar reviews, etc.
 */
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
    
    public Espacio getEspacio(){
    	return espacio;
    }

    public Lugar getLugar(){
        return lugar;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String n) {
    	nombre = n;
    }

    public abstract double getPrecio();

    public Tipo getTipo() {
        return tipo;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }
    
    public void setPrecio(double p){
    	precio = p;
    	anuncio.notificar(); //TODO: La idea es que notifique el cambio una vez se cambie el precio. Igualmente podria extrapolarse
    }

    /**
     * Obtiene el promedio de las calificaciones
     * @return El promedio de todas las reseñas
     */
    public double getPromedioReviews(){
        if(reviews.isEmpty()) return 0;
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
        reviews.add(r);
    }
}