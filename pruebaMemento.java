import Estructura.*;
import DeComportamiento.Memento.*;

public class pruebaMemento {

    public static void main(String[] args) {
        System.out.println("=== PRUEBA DEL PATRÓN MEMENTO (Airbnb - Edición de Alojamiento) ===");

        // 1. Crear el alojamiento (un Apartamento)
        Alojamiento apto = new Apartamento(120.0);
        apto.setNombre("Penthouse Vista al Mar");
        apto.setDisponible(true);

        // Mostrar estado inicial
        System.out.println("\n--- Estado Inicial del Alojamiento ---");
        imprimirEstado(apto);

        // 2. Instanciar el Caretaker
        AlojamientoCaretaker caretaker = new AlojamientoCaretaker();

        // 3. El anfitrión decide editar el alojamiento
        System.out.println("\n[Anfitrión]: Editando el alojamiento...");
        
        // Guardamos el estado actual (Memento 1 - Estado Inicial) antes de realizar el cambio
        caretaker.guardar(apto.save());

        // Realizamos el primer cambio (Cambio de Precio e Inclusión de Nombre nuevo)
        apto.setPrecio(150.0);
        apto.setNombre("Penthouse Vista al Mar (Modificado)");
        System.out.println("\n--- Después de la Edición 1 ---");
        imprimirEstado(apto);

        // Guardamos este nuevo estado (Memento 2 - Edición 1) antes de otro cambio
        caretaker.guardar(apto.save());

        // Realizamos un segundo cambio (Desactivar disponibilidad y subir precio)
        apto.setPrecio(200.0);
        apto.setDisponible(false);
        System.out.println("\n--- Después de la Edición 2 ---");
        imprimirEstado(apto);

        // 4. El anfitrión comete un error o decide arrepentirse (Deshacer / Undo)
        System.out.println("\n[Anfitrión]: Presiona 'Deshacer' (Undo)...");
        if (caretaker.puedeDeshacer()) {
            // Guardamos el estado actual para poder rehacerlo si fuera necesario, y restauramos el anterior
            AlojamientoMemento mementoAnterior = caretaker.deshacer(apto.save());
            apto.restore(mementoAnterior);
        }
        System.out.println("--- Después del 1er Deshacer (vuelve a Edición 1) ---");
        imprimirEstado(apto);

        // Deshacer otra vez (volver al estado inicial)
        System.out.println("\n[Anfitrión]: Presiona 'Deshacer' (Undo) de nuevo...");
        if (caretaker.puedeDeshacer()) {
            AlojamientoMemento mementoInicial = caretaker.deshacer(apto.save());
            apto.restore(mementoInicial);
        }
        System.out.println("--- Después del 2do Deshacer (vuelve a Estado Inicial) ---");
        imprimirEstado(apto);

        // 5. El anfitrión cambia de opinión y quiere recuperar el cambio anterior (Rehacer / Redo)
        System.out.println("\n[Anfitrión]: Presiona 'Rehacer' (Redo)...");
        if (caretaker.puedeRehacer()) {
            AlojamientoMemento mementoSiguiente = caretaker.rehacer(apto.save());
            apto.restore(mementoSiguiente);
        }
        System.out.println("--- Después de Rehacer (vuelve a Edición 1) ---");
        imprimirEstado(apto);
    }

    private static void imprimirEstado(Alojamiento a) {
        System.out.println("Nombre      : " + a.getNombre());
        // getPrecio() multiplica el precio por 1.2 en Apartamento (ver clase Apartamento)
        System.out.println("Precio Base : " + a.getPrecio()); 
        System.out.println("Disponible  : " + (a.disponible ? "Sí" : "No"));
    }
}
