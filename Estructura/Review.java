package Estructura;
/**
 * Representa una reseña de un alojamiento. Tiene campos para el usuario asociado y su calificacion
 */
public class Review{
    public String usuario;
    public Integer nota;
    
    public Review(String user, int note){
        usuario = user;
        nota = note;
    }

    public Review(){
        this("", 0);
    }
}