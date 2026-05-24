import java.util.ArrayList;
public class ListaCasas{
    public ArrayList<Casa> casas;
    private Estrategia sorter;

    public ListaCasas(){
        casas = new ArrayList<>();
    }

    public void addCasa(Casa casa){
        casas.add(casa);
    }

    public void ordenar(){
        casas = sorter.ordenar(casas);
    }

    public void setSorter(Estrategia s){
        sorter = s;
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