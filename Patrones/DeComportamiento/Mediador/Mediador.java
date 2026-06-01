package DeComportamiento.Mediador;

/**
 * Representa a un mediador entre chats de usuarios
 */
public interface Mediador {
	/**
	 * Envia un mensaje al usuario objetivo
	 * @param destino El nombre del usuario destino
	 * @param contenido Un string
	 */
	public void enviarMensaje(String destino, String contenido);
	public void setReceptor(User r);
	public void setEmisor(User e);
}
