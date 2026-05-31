import Estructura.Usuario;
import DeComportamiento.Comando.*;

public class pruebaComando {
    public static void main(String[] args) {
        System.out.println("=== INICIALIZANDO DEMOSTRACIÓN DEL PATRÓN COMANDO ===");

        // 1. Inicializar el receptor (Usuario)
        Usuario usuario = new Usuario("Sebastian", "seb0c@example.com", "3001234567", false);
        System.out.println("Estado Inicial:");
        System.out.println(usuario);
        System.out.println("--------------------------------------------------\n");

        // 2. Inicializar el Invocador (Panel de la UI)
        PanelPreferencias panel = new PanelPreferencias();

        // 3. Crear y ejecutar los comandos a través del panel
        System.out.println("--- Ejecutando Cambios en el Perfil ---");
        Comando cambiarEmail = new ComandoActualizarEmail(usuario, "nuevo_correo@example.com");
        panel.ejecutarAccion(cambiarEmail);

        Comando cambiarTelefono = new ComandoActualizarTelefono(usuario, "3159876543");
        panel.ejecutarAccion(cambiarTelefono);

        Comando alternarNotif = new ComandoMostrarNotificaciones(usuario);
        panel.ejecutarAccion(alternarNotif);

        System.out.println("\nEstado tras las modificaciones:");
        System.out.println(usuario);
        System.out.println("--------------------------------------------------\n");

        // 4. Deshacer las acciones una por una
        System.out.println("--- Revirtiendo Acciones (Undo) ---");

        System.out.println("\n[Deshacer 1: Notificaciones]");
        panel.deshacerAccion();

        System.out.println("\n[Deshacer 2: Teléfono]");
        panel.deshacerAccion();

        System.out.println("\n[Deshacer 3: Email]");
        panel.deshacerAccion();

        System.out.println("\n--------------------------------------------------");
        System.out.println("Estado Final del Usuario (Debe ser idéntico al inicial):");
        System.out.println(usuario);

        // 5. Intento de deshacer extra para validar estabilidad
        System.out.println("\n[Deshacer Extra]");
        panel.deshacerAccion();
    }
}