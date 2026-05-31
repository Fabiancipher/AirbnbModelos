package DeComportamiento.Comando;

import Estructura.Usuario;

public class ComandoMostrarNotificaciones implements Comando {
    private Usuario usuario;

    public ComandoMostrarNotificaciones(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void ejecutar() {
        usuario.cambiarEstadoNotificaciones();
        System.out.println("[Comando] Notificaciones cambiadas a: "
                + (usuario.getMostrarNotificaciones() ? "ACTIVADAS" : "DESACTIVADAS"));
    }

    @Override
    public void deshacer() {
        // Al ser un toggle, revertir la acción es volver a alternar el estado
        usuario.cambiarEstadoNotificaciones();
        System.out.println("[Deshacer] Notificaciones revertidas a: "
                + (usuario.getMostrarNotificaciones() ? "ACTIVADAS" : "DESACTIVADAS"));
    }
}