public class Lugar{
    private final String ciudad;
    private final String pais;

    public Lugar(String c, String p){
        ciudad = c;
        pais = p;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }
}