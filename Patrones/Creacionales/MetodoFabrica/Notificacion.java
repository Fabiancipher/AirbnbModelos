package Creacionales.MetodoFabrica;

import Estructura.Usuario;

public interface Notificacion {
    void enviar(Usuario destinatario, String mensaje);
}
