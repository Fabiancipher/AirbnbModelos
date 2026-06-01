package Creacionales.MetodoFabrica;

public class NotificadorPush extends Notificador {
    @Override
    protected Notificacion crearNotificacion() {
        return new NotificacionPush();
    }
}
