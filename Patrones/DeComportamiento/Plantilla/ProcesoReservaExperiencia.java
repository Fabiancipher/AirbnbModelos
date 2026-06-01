package DeComportamiento.Plantilla;

import Estructura.Reserva;
import Estructura.Experiencia;

public class ProcesoReservaExperiencia extends ProcesoReserva {

    @Override
    protected boolean validarDisponibilidad(Reserva reserva) {
        Experiencia experiencia = reserva.getExperiencia();
        if (experiencia == null) {
            System.out.println("   [Experiencia]: No se especificó ninguna experiencia para esta reserva.");
            return false;
        }
        System.out.println("   [Experiencia]: Verificando agenda y disponibilidad de la experiencia.");
        return true; // Asumimos disponible si existe para propósitos de simulación
    }

    @Override
    protected double calcularCosto(Reserva reserva) {
        Experiencia experiencia = reserva.getExperiencia();
        // Las experiencias tienen un seguro médico obligatorio para actividades al aire libre
        double precioBase = 50.0; // Precio base simulado
        double seguro = 5.0;
        System.out.printf("   [Experiencia]: Costo Base de la actividad: $%.2f, Seguro Obligatorio: $%.2f%n", precioBase, seguro);
        return precioBase + seguro;
    }
}
