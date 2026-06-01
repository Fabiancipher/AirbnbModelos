package Creacionales.MetodoFabrica;

import Estructura.Usuario;

public class NotificacionEmail implements Notificacion {
    @Override
    public void enviar(Usuario destinatario, String mensaje) {
        System.out.println("[Email] Enviando a " + destinatario.getNombre() + " (" + destinatario.getEmail() + "):");
        System.out.println("        \"" + mensaje + "\"");
    }
}
