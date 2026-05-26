package Estructura;
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