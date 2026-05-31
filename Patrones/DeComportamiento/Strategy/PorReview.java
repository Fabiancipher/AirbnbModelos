package DeComportamiento.Strategy;
import java.util.ArrayList;
import java.util.Comparator;
import Estructura.Alojamiento;
/**
 * Ordena en base al promedio de reseñas de los alojamientos. En orden ascendente
 */
public class PorReview implements Estrategia{
    @Override
    public ArrayList<Alojamiento> ordenar(ArrayList<Alojamiento> lista) {
        lista.sort(Comparator.comparing(Alojamiento::getPromedioReviews));
        return lista;
    }
}