package Creacionales.MetodoFabrica;

import Estructura.Usuario;

public class NotificacionPush implements Notificacion {
    @Override
    public void enviar(Usuario destinatario, String mensaje) {
        System.out.println("[Push Notification] Enviando alerta a dispositivo de " + destinatario.getNombre() + ":");
        System.out.println("                    \"" + mensaje + "\"");
    }
}
