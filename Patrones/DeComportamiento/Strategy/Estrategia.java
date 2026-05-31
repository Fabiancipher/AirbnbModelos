package DeComportamiento.Strategy;
import java.util.ArrayList;
import Estructura.Alojamiento;
/**
 * Representa formas de ordenar una lista de alojamientos
 */
public interface Estrategia{
    public ArrayList<Alojamiento> ordenar(ArrayList<Alojamiento> lista);
}