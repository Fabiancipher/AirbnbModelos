package Creacionales.MetodoFabrica;

public class NotificadorSMS extends Notificador {
    @Override
    protected Notificacion crearNotificacion() {
        return new NotificacionSMS();
    }
}
