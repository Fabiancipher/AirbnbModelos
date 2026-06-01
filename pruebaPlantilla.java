import Estructura.*;
import DeComportamiento.Plantilla.*;
import Estructurales.Composite.Ciudad;

public class pruebaPlantilla {
    public static void main(String[] args) {
        System.out.println("=== INICIALIZANDO DEMOSTRACIÓN DEL PATRÓN MÉTODO PLANTILLA ===");

        // 1. Inicializar entidades del dominio
        Usuario cliente = new Usuario("Carlos Gomez", "carlos@example.com", "3201112233", true);
        
        Alojamiento apto = new Apartamento(100.0);
        apto.setNombre("Apartamento Central Con Vista");
        apto.disponible = true;

        Servicio servicioMasaje = new Masaje("Masaje Shiatsu");
        Experiencia tourGuiado = new Cultural("Tour Histórico del Centro");
        Lugar destinoCiudad = new Ciudad("Bogotá");

        // 2. Crear una reserva de Alojamiento
        Reserva reservaAlojamiento = new ReservaBase(apto, servicioMasaje, null, destinoCiudad);

        // 3. Crear una reserva de Experiencia (solo la experiencia)
        Reserva reservaExperiencia = new ReservaBase(null, null, tourGuiado, destinoCiudad);

        // 4. Instanciar los procesadores de reservas (Plantillas concretas)
        ProcesoReserva procesadorAlojamiento = new ProcesoReservaAlojamiento();
        ProcesoReserva procesadorExperiencia = new ProcesoReservaExperiencia();

        // 5. Ejecutar plantilla de reserva para Alojamiento
        System.out.println("\n--- Caso 1: Procesando Reserva de Alojamiento ---");
        procesadorAlojamiento.procesarReserva(cliente, reservaAlojamiento);

        // 6. Ejecutar plantilla de reserva para Experiencia
        System.out.println("\n--- Caso 2: Procesando Reserva de Experiencia ---");
        procesadorExperiencia.procesarReserva(cliente, reservaExperiencia);

        // 7. Caso de fallo: Alojamiento no disponible
        System.out.println("\n--- Caso 3: Intento de Reserva con Alojamiento No Disponible ---");
        apto.disponible = false;
        procesadorAlojamiento.procesarReserva(cliente, reservaAlojamiento);
    }
}
