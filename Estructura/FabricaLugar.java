import java.util.HashMap;
/**
 * Clase que mantiene un registro de los lugares que se van registrando
 */
public class FabricaLugar{
    private final HashMap<String, Lugar> cache;

    public FabricaLugar(){
        cache = new HashMap<>();
    }

    public Lugar getLugar(String ciudad, String pais){
        String key = ciudad + ", " + pais;
        if(!cache.containsKey(key)){
            cache.put(key, new Lugar(ciudad, pais));
        }
        return cache.get(key);
    }
}