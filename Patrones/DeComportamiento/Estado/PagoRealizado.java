package DeComportamiento.Estado;

public class PagoRealizado implements EstadoPago {
	private final Pago contexto;
	
	public PagoRealizado(Pago c) {
		contexto = c;
	}
	
	@Override
	public String ingresarMetodo() {
		return "Ya ingresado";
	}
	
	@Override
	public String cancelar() {
		return "Imposible cancelar";
	}
	
	@Override
	public String pagar() {
		contexto.setEstado(new EnEspera(contexto));
		return "Pago realizado";
	}
}