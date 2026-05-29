package Estructurales.Flyweight;

import Estructura.Servicio;
import Creacionales.Fabrica.*;

import java.util.HashMap;
/**
 * Clase que mantiene un registro de los lugares que se van registrando
 */
public class FabricaServicios{
    private final HashMap<String, Servicio> cache;
    private final FabricaAbstracta fabrica;

    public FabricaServicios(FabricaAbstracta f){
        cache = new HashMap<>();
        fabrica = f;
    }

    public Servicio getServicio(String n){
        if(!cache.containsKey(n)){
            cache.put(n, fabrica.crearServicio(n));
        }
        return cache.get(n);
    }
}