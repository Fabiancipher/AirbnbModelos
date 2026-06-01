// PATRÓN: Memento – guarda y restaura estados de un anuncio

export class MementoManager {
    constructor(estadoInicial) {
        this.snapshots = [JSON.stringify(estadoInicial)]
        this.cursor = 0
    }

    guardar(estado) {
        this.snapshots = this.snapshots.slice(0, this.cursor + 1)
        this.snapshots.push(JSON.stringify(estado))
        this.cursor++
    }

    deshacer() {
        if (this.cursor > 0) this.cursor--
        return JSON.parse(this.snapshots[this.cursor])
    }

    rehacer() {
        if (this.cursor < this.snapshots.length - 1) this.cursor++
        return JSON.parse(this.snapshots[this.cursor])
    }

    puedeDeshacer() { return this.cursor > 0 }
    puedeRehacer() { return this.cursor < this.snapshots.length - 1 }
}