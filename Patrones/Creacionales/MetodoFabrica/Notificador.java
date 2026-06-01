package Creacionales.MetodoFabrica;

import Estructura.Usuario;

public abstract class Notificador {
    // El Método Fábrica que las subclases implementarán
    protected abstract Notificacion crearNotificacion();

    // Operación común que hace uso del método fábrica
    public void notificar(Usuario destinatario, String mensaje) {
        Notificacion notificacion = crearNotificacion();
        notificacion.enviar(destinatario, mensaje);
    }
}
