package Creacionales.Singleton;

import DeComportamiento.Iterador.*;

import java.util.ArrayList;

import Estructura.Alojamiento;
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
    
    /**
     * Obtiene el alojamiento asociado al indice indicado
     * <p>
     * Para ser usado junto a los iteradores
     * @param i El indice
     * @see IteradorAlojamiento
     * @return Un alojamiento
     * */
    public Alojamiento getAlojamiento(int i) { //Definitivamente una solución poco ideal.
    	return casas.get(i);					//Se supone que el usuario no interactua directamente con esto
    }											//sino con el iterador, pero no deja de ser una brecha.
    
    /**
     * Obtiene el tamaño actual de la lista
     * @return Un entero - el tamaño de la lista -
     */
    public int getSize() {
    	return casas.size();
    }
    
    /**
     * Obtiene un nuevo iterador descendente asociado a esta lista
     * @return Un iterador que va de atras hacia adelante
     */
    public IteradorAlojamientos getDescendente() {
    	return new IteradorDescendente(this);
    }
    
    /**
     * Obtiene la única instancia de ListaAlojamientos que puede existir durante ejecución
     * @return La instancia de ListaAlojamientos
     */
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