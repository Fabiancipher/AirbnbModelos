package DeComportamiento.Estado;

public class EnEspera implements EstadoPago {
	private final Pago contexto;
	
	public EnEspera(Pago c) {
		contexto = c;
	}
	
	@Override
	public String ingresarMetodo() {
		return "Primero dirijase a realizar el pago...";
	}
	
	@Override
	public String cancelar() {
		return "No hay pago a cancelar";
	}
	
	@Override
	public String pagar() {
		contexto.setEstado(new ListoPago(contexto));
		return "Dirigiendose al pago...";
	}
}
