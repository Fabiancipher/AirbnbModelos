import java.util.ArrayList;
/**
 * ListaCasas es una clase que representa una colección de objetos Casa.
 * Permite agregar casas a la lista y ordenar las casas utilizando diferentes estrategias de ordenamiento
 */
public class ListaCasas{
    public ArrayList<Casa> casas;
    private Estrategia sorter;
    private static ListaCasas instancia;

    private ListaCasas(){
        casas = new ArrayList<>();
    }

    /**
     * Agrega una casa a la lista de casas.
     * @param casa La casa que se desea agregar a la lista.
     */
    public void addCasa(Casa casa){
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

    public static ListaCasas getInstancia(){
        if(instancia==null) instancia = new ListaCasas();
        return instancia;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Casa c : casas){
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}