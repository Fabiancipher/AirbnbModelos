import java.util.ArrayList;
import java.util.Comparator;
public class PorLugar implements Estrategia{
    @Override
    public ArrayList<Casa> ordenar(ArrayList<Casa> lista) {
        lista.sort(Comparator.comparing(Casa::getLugar));
        return lista;
    }
}