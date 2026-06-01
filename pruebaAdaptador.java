import Estructura.Usuario;
import Estructurales.Adaptador.*;

public class pruebaAdaptador {
    public static void main(String[] args) {
        System.out.println("=== INICIALIZANDO DEMOSTRACIÓN DEL PATRÓN ADAPTADOR ===");

        // 1. Inicializar usuario del sistema
        Usuario cliente = new Usuario("Roberto Gomez", "roberto.g@example.com", "3007654321", true);
        System.out.println("Cliente: " + cliente.getNombre() + " (" + cliente.getEmail() + ")");
        double montoACobrar = 145.50; // Monto en USD
        System.out.printf("Monto a debitar: $%.2f USD%n", montoACobrar);
        System.out.println("--------------------------------------------------\n");

        // 2. Instanciar la API externa (incompatible)
        StripeAPI stripeSDK = new StripeAPI();

        // 3. Instanciar el adaptador para conectar nuestro sistema con la API externa
        System.out.println("--- Conectando a través del StripeAdapter ---");
        ProcesadorPago procesador = new StripeAdapter(stripeSDK, "tok_visa_default");

        // 4. Ejecutar el cobro de forma transparente usando nuestra interfaz estándar
        procesador.debitar(cliente, montoACobrar);

        System.out.println("\n--------------------------------------------------");
        System.out.println("¡El cobro se ha completado de forma transparente usando la interfaz estándar!");
    }
}
