package Creacionales.MetodoFabrica;

import Estructura.Usuario;

public class NotificacionSMS implements Notificacion {
    @Override
    public void enviar(Usuario destinatario, String mensaje) {
        System.out.println("[SMS] Enviando al número " + destinatario.getTelefono() + " de " + destinatario.getNombre() + ":");
        System.out.println("      \"" + mensaje + "\"");
    }
}
