package DeComportamiento.Plantilla;

import Estructura.Reserva;
import Estructura.Usuario;

public abstract class ProcesoReserva {

    // El Método Plantilla
    public final void procesarReserva(Usuario cliente, Reserva reserva) {
        System.out.println("\n>>> INICIANDO PROCESAMIENTO DE RESERVA PARA: " + cliente.getNombre());
        
        if (!validarDisponibilidad(reserva)) {
            System.out.println("❌ ERROR: El servicio solicitado no está disponible.");
            return;
        }

        double costo = calcularCosto(reserva);
        System.out.printf("   [Costo Calculado]: $%.2f%n", costo);

        ejecutarPago(cliente, costo);
        registrarReserva(reserva);
        enviarConfirmacion(cliente, reserva);
        
        System.out.println(">>> RESERVA COMPLETADA EXITOSAMENTE.");
    }

    // Pasos abstractos a ser definidos por las subclases
    protected abstract boolean validarDisponibilidad(Reserva reserva);
    protected abstract double calcularCosto(Reserva reserva);

    // Pasos comunes con lógica por defecto o fija
    private void ejecutarPago(Usuario cliente, double monto) {
        System.out.printf("   [Pago]: Debitando $%.2f del correo %s%n", monto, cliente.getEmail());
    }

    private void registrarReserva(Reserva reserva) {
        System.out.println("   [Sistema]: Guardando reserva en la base de datos de Airbnb...");
    }

    private void enviarConfirmacion(Usuario cliente, Reserva reserva) {
        System.out.println("   [Notificación]: Enviando confirmación de reserva a " + cliente.getNombre());
    }
}
