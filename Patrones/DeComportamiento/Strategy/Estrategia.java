package DeComportamiento.Strategy;
import java.util.ArrayList;
import Estructura.Alojamiento;
public interface Estrategia{
    public ArrayList<Alojamiento> ordenar(ArrayList<Alojamiento> lista);
}