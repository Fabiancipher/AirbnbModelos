package Estructurales.Flyweight;

import Estructura.Experiencia;
import Creacionales.Fabrica.*;

import java.util.HashMap;
/**
 * Clase que mantiene un registro de los lugares que se van registrando
 */
public class FabricaExperiencias{
    private final HashMap<String, Experiencia> cache;
    private final FabricaAbstracta fabrica;

    public FabricaExperiencias(FabricaAbstracta f){
        cache = new HashMap<>();
        fabrica = f;
    }

    public Experiencia getExperiencia(String p){
        if(!cache.containsKey(p)){
            cache.put(p, fabrica.crearExperiencia(p));
        }
        return cache.get(p);
    }
}
