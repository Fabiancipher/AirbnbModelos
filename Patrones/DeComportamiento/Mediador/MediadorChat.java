package DeComportamiento.Mediador;

import EntradasSalidas.SalidaConsola;

public class MediadorChat implements Mediador{
	
	private User receptor;
	private User emisor;
	private final SalidaConsola salida;
	
	/**
	 * Para determinar emisor y receptor en la construcción
	 * @param r Receptor
	 * @param e Emisor
	 */
	public MediadorChat(User r, User e) {
		e.setMediador(this);
		r.setMediador(this);
		salida = new SalidaConsola();
		receptor = r;
		emisor = e;
	}
	
	public MediadorChat() {
		salida = new SalidaConsola();
	}
	
	@Override
	public void setReceptor(User r) {
		r.setMediador(this);
		receptor = r;
	}
	
	@Override
	public void setEmisor(User e) {
		e.setMediador(this);
		emisor = e;
	}
	
	@Override
	public void enviarMensaje(String destino, String contenido) {
		if(destino.equals("Anfitrion")) {
		    salida.enviar(receptor.recibir("Un huesped interesado dijo: "+contenido));
			return;
		}
		else if(destino.equals(emisor.getNombre())) {
			salida.enviar(emisor.recibir("Memo: "+contenido));
			return;
		}
		salida.enviar(receptor.recibir("Un usuario dijo: "+contenido));
	}
	
}
