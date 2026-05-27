package Estructurales.Flyweight;
import java.util.HashMap;

import Estructura.Lugar;
import Estructurales.Composite.Pais;
/**
 * Clase que mantiene un registro de los lugares que se van registrando
 */
public class FabricaPais{
    private final HashMap<String, Lugar> cache;

    public FabricaPais(){
        cache = new HashMap<>();
    }

    public Lugar getLugar(String n){
        if(!cache.containsKey(n)){
            cache.put(n, new Pais(n));
        }
        return cache.get(n);
    }
}