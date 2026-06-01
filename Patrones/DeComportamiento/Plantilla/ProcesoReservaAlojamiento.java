package DeComportamiento.Plantilla;

import Estructura.Reserva;
import Estructura.Alojamiento;

public class ProcesoReservaAlojamiento extends ProcesoReserva {

    @Override
    protected boolean validarDisponibilidad(Reserva reserva) {
        Alojamiento alojamiento = reserva.getAlojamiento();
        if (alojamiento == null) {
            System.out.println("   [Alojamiento]: No se especificó ningún alojamiento para esta reserva.");
            return false;
        }
        System.out.println("   [Alojamiento]: Verificando disponibilidad del alojamiento: " + alojamiento.getNombre());
        return alojamiento.disponible;
    }

    @Override
    protected double calcularCosto(Reserva reserva) {
        Alojamiento alojamiento = reserva.getAlojamiento();
        // Sumar precio base más una tarifa de limpieza estándar
        double precioBase = alojamiento.getPrecio();
        double tarifaLimpieza = 25.0;
        System.out.printf("   [Alojamiento]: Precio Base: $%.2f, Tarifa Limpieza: $%.2f%n", precioBase, tarifaLimpieza);
        return precioBase + tarifaLimpieza;
    }
}
