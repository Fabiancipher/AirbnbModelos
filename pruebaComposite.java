import Estructura.*;
import Estructurales.Composite.*;
public class pruebaComposite {

	public static void main(String[] args) {
		
		Lugar pais = new Pais("Colombia");
		Lugar ciudad = new Ciudad("Bogotá");
		
		Lugar ciudad2 = new Ciudad("Medellin");
		
		pais.add(ciudad);
		pais.add(ciudad2);
		
		ciudad.add(ciudad2);
	}

}
