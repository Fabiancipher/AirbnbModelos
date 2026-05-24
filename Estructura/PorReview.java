import java.util.ArrayList;
import java.util.Comparator;
public class PorReview implements Estrategia{
    @Override
    public ArrayList<Casa> ordenar(ArrayList<Casa> lista) {
        lista.sort(Comparator.comparing(Casa::getPromedioReviews));
        return lista;
    }
}