package DeComportamiento.Comando;

import java.util.Stack;

public class PanelPreferencias {
    private Stack<Comando> historial = new Stack<>();

    public void ejecutarAccion(Comando comando) {
        comando.ejecutar();
        historial.push(comando);
    }

    public void deshacerAccion() {
        if (!historial.isEmpty()) {
            Comando ultimoComando = historial.pop();
            ultimoComando.deshacer();
        } else {
            System.out.println("No hay acciones pendientes por deshacer.");
        }
    }
}