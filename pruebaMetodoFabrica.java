import Estructura.Usuario;
import Creacionales.MetodoFabrica.*;

public class pruebaMetodoFabrica {
    public static void main(String[] args) {
        System.out.println("=== INICIALIZANDO DEMOSTRACIÓN DEL PATRÓN MÉTODO FÁBRICA ===");

        // 1. Inicializar usuarios de prueba (Huésped y Anfitrión)
        Usuario huesped = new Usuario("Juan Perez", "juan.perez@example.com", "3004567890", true);
        Usuario anfitrion = new Usuario("Maria Lopez", "maria.host@example.com", "3119876543", false);

        System.out.println("Usuarios registrados:");
        System.out.println("Huésped: " + huesped.getNombre() + " (" + huesped.getEmail() + ")");
        System.out.println("Anfitrión: " + anfitrion.getNombre() + " (" + anfitrion.getEmail() + ")");
        System.out.println("--------------------------------------------------\n");

        // 2. Simular envío de notificación por Email
        System.out.println("--- Enviando Notificación por Email ---");
        Notificador notificadorEmail = new NotificadorEmail();
        notificadorEmail.notificar(huesped, "Tu reserva en 'Cabaña del Bosque' ha sido confirmada con éxito!");

        // 3. Simular envío de notificación por SMS
        System.out.println("\n--- Enviando Notificación por SMS ---");
        Notificador notificadorSMS = new NotificadorSMS();
        notificadorSMS.notificar(anfitrion, "Nuevo mensaje de Juan Perez: ¿A qué hora puedo hacer el check-in?");

        // 4. Simular envío de notificación Push
        System.out.println("\n--- Enviando Notificación Push ---");
        Notificador notificadorPush = new NotificadorPush();
        notificadorPush.notificar(huesped, "¡Tu anfitrión ha aceptado tu solicitud de modificación de fechas!");
    }
}
