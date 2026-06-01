// PATRÓN: Builder – construcción paso a paso de una reserva

export class ReservaBuilder {
    constructor() {
        this.reset()
    }

    reset() {
        this._reserva = {
            alojamiento: null,
            experiencia: null,
            servicio: null,
            fechaEntrada: '',
            fechaSalida: '',
            huespedes: 1,
            extras: [],
            precioBase: 0,
            precioFinal: 0,
        }
    }

    setAlojamiento(aloj) {
        this._reserva.alojamiento = aloj
        this._reserva.precioBase = aloj.precio
        this._reserva.precioFinal = aloj.precio
        return this
    }

    setExperiencia(exp) {
        this._reserva.experiencia = exp
        return this
    }

    setServicio(srv) {
        this._reserva.servicio = srv
        return this
    }

    setFechas(entrada, salida) {
        this._reserva.fechaEntrada = entrada
        this._reserva.fechaSalida = salida
        return this
    }

    setHuespedes(n) {
        this._reserva.huespedes = n
        return this
    }

    build() {
        const r = { ...this._reserva }
        this.reset()
        return r
    }
}