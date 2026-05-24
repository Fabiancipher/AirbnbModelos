import java.util.ArrayList;
import java.util.Comparator;
public class PorPrecio implements Estrategia{

    @Override
    public ArrayList<Casa> ordenar(ArrayList<Casa> lista){
        lista.sort(Comparator.comparing(Casa::getPrecio));
        return lista;
    }
}