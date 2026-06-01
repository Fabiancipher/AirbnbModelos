package DeComportamiento.Estado;

public class ListoPago implements EstadoPago {
	private final Pago contexto;
	
	public ListoPago(Pago c) {
		contexto = c;
	}
	
	@Override
	public String ingresarMetodo() {
		contexto.setEstado(new PagoRealizado(contexto));
		return "Utilizando tarjeta debito...";
	}
	
	@Override
	public String cancelar() {
		contexto.setEstado(new EnEspera(contexto));
		return "Cancelando...";
	}
	
	@Override
	public String pagar() {
		return "Primero ingrese un metodo de pago...";
	}
}