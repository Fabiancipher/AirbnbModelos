// PATRÓN: Command – acciones con undo/redo encapsuladas

export class CommandManager {
    constructor() {
        this.historial = []
        this.posicion = -1
    }

    ejecutar(comando) {
        // Elimina redo history si hay comandos adelante
        this.historial = this.historial.slice(0, this.posicion + 1)
        this.historial.push(comando)
        this.posicion++
        comando.ejecutar()
    }

    deshacer() {
        if (this.posicion < 0) return
        this.historial[this.posicion].deshacer()
        this.posicion--
    }

    rehacer() {
        if (this.posicion >= this.historial.length - 1) return
        this.posicion++
        this.historial[this.posicion].ejecutar()
    }

    puedeDeshacer() { return this.posicion >= 0 }
    puedeRehacer() { return this.posicion < this.historial.length - 1 }
}

export function crearComandoEdicion(campo, valorAnterior, valorNuevo, setter) {
    return {
        label: `Cambiar ${campo}`,
        ejecutar: () => setter(prev => ({ ...prev, [campo]: valorNuevo })),
        deshacer: () => setter(prev => ({ ...prev, [campo]: valorAnterior })),
    }
}