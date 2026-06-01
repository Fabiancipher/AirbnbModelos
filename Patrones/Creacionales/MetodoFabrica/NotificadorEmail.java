package Creacionales.MetodoFabrica;

public class NotificadorEmail extends Notificador {
    @Override
    protected Notificacion crearNotificacion() {
        return new NotificacionEmail();
    }
}
