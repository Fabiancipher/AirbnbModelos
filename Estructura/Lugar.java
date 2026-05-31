package Estructura;
/**
 * Representa, principalmente, el nombre de un espacio físico. Ya sea un país, ciudad, o la dirección del alojamiento
 */
public abstract class Lugar{
    public String nombre;
    
    /**
     * Añade un lugar a la lista de "hijos". Si la subclase soporta la operacion
     * @param a Un lugar
     */
    public void add(Lugar a) {
    	
    }
    
    /**
     * Remueve un lugar de la lista de "hijos". Si la subclase soporta la operacion
     * @param a
     */
    public void remove(Lugar a) {
    	
    }
    
    public String getNombre() {
    	return nombre;
    }
}