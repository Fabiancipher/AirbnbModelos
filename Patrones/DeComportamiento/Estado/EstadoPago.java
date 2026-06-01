package DeComportamiento.Estado;

public interface EstadoPago {
	/**
	 * Acción de ingresar un metodo de pago
	 * @return Información de dicho metodo
	 */
	public String ingresarMetodo();
	/**
	 * Acción de cancelar un pago
	 * @return Información de la cancelación
	 */
	public String cancelar();
	/**
	 * Acción de pagar
	 * @return Información del pago
	 */
	public String pagar();
}
