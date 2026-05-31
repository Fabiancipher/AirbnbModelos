package DeComportamiento.Memento;

import java.util.Stack;

/**
 * Caretaker que gestiona el historial de estados (Mementos) de un Alojamiento.
 * Permite realizar acciones de Deshacer (Undo) y Rehacer (Redo).
 */
public class AlojamientoCaretaker {
    private final Stack<AlojamientoMemento> undoStack = new Stack<>();
    private final Stack<AlojamientoMemento> redoStack = new Stack<>();

    /**
     * Guarda el estado actual en el historial de Deshacer y limpia el de Rehacer.
     */
    public void guardar(AlojamientoMemento memento) {
        undoStack.push(memento);
        redoStack.clear(); // Una nueva edición invalida el historial de rehacer
    }

    /**
     * Extrae el último estado del historial de Deshacer y guarda el estado actual en el de Rehacer.
     * @param estadoActual El estado actual del Alojamiento antes de deshacer.
     * @return El Memento del estado anterior, o null si no hay historial para deshacer.
     */
    public AlojamientoMemento deshacer(AlojamientoMemento estadoActual) {
        if (!undoStack.isEmpty()) {
            redoStack.push(estadoActual);
            return undoStack.pop();
        }
        return null;
    }

    /**
     * Extrae el último estado del historial de Rehacer y guarda el estado actual en el de Deshacer.
     * @param estadoActual El estado actual del Alojamiento antes de rehacer.
     * @return El Memento del estado posterior, o null si no hay historial para rehacer.
     */
    public AlojamientoMemento rehacer(AlojamientoMemento estadoActual) {
        if (!redoStack.isEmpty()) {
            undoStack.push(estadoActual);
            return redoStack.pop();
        }
        return null;
    }

    public boolean puedeDeshacer() {
        return !undoStack.isEmpty();
    }

    public boolean puedeRehacer() {
        return !redoStack.isEmpty();
    }
}
