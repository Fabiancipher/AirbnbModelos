package DeComportamiento.Strategy;
import java.util.ArrayList;
import java.util.Comparator;
import Estructura.Alojamiento;
public class PorPrecio implements Estrategia{

    @Override
    public ArrayList<Alojamiento> ordenar(ArrayList<Alojamiento> lista){
        lista.sort(Comparator.comparing(Alojamiento::getPrecio));
        return lista;
    }
}