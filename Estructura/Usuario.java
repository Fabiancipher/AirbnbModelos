package Estructura;

public abstract class Usuario {
	public String nombre;
	
    public void reservar() {
		realizarPago();
		verificar();
	}
	public abstract void realizarPago();
	public abstract Boolean verificar();
}
