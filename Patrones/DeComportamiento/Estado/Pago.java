package DeComportamiento.Estado;

public class Pago {
	private EstadoPago estado;
	public Pago() {
		estado = new EnEspera(this);
	}
	
	public void setEstado(EstadoPago e) {
		estado = e;
	}
	
	public String ingresarMetodo() {
		return estado.ingresarMetodo();
	}
	
	public String cancelar() {
		return estado.cancelar();
	}
	
	public String pagar() {
		return estado.pagar();
	}
}
