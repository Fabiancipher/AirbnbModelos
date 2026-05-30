package Estructura;
import java.util.ArrayList;
public abstract class Alojamiento{
    protected Lugar lugar;
    protected Tipo tipo;
    protected Espacio espacio;
    protected double precio;
    protected String nombre;
    protected ArrayList<Review> reviews;
    protected Anuncio anuncio;
    public boolean disponible;
    
    public Espacio getEspacio(){
    	return espacio;
    }

    public Lugar getLugar(){
        return lugar;
    }

    public String getNombre() {
        return nombre;
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
    	anuncio.notificar();
    }

    public double getPromedioReviews(){
        if(reviews.isEmpty()) return 0;
        int sum = 0;
        for(Review r : reviews){
            sum += r.nota;
        }
        return (double)sum / reviews.size();
    }

    public void agregarReview(Review r){
        reviews.add(r);
    }
}