package Estructura;
import java.util.ArrayList;
import DeComportamiento.Strategy.Estrategia;
/**
 * ListaCasas es una clase que representa una colección de objetos Alojamiento.
 * Permite agregar alojamientos a la lista y ordenar las casas utilizando diferentes estrategias de ordenamiento
 */
public class ListaAlojamientos{
    private ArrayList<Alojamiento> casas;
    private Estrategia sorter;
    private static ListaAlojamientos instancia;

    private ListaAlojamientos(){
        casas = new ArrayList<>();
    }

    /**
     * Agrega una casa a la lista de casas.
     * @param casa La casa que se desea agregar a la lista.
     */
    public void addAlojamiento(Alojamiento casa){
        casas.add(casa);
    }

    /**
     * Ordena la lista de casas utilizando la estrategia de ordenamiento establecida.
     */
    public void ordenar(){
        casas = sorter.ordenar(casas);
    }

    public void setSorter(Estrategia s){
        sorter = s;
    }

    public static ListaAlojamientos getInstancia(){
        if(instancia==null) instancia = new ListaAlojamientos();
        return instancia;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Alojamiento c : casas){
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}