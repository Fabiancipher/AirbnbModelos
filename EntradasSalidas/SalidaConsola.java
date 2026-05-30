package EntradasSalidas;
public class SalidaConsola implements Salida{
	public SalidaConsola() {
		
	}
	
    @Override
    public void enviar(String m){
        System.out.println(m);
    }

    @Override
    public void enviar(double m){
        System.out.println(m);
    }

    @Override
    public void enviar(Object m){
        System.out.println(m);
    }
}