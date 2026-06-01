// PATRÓN: State – el pago transiciona entre estados bien definidos

export const ESTADOS = {
    ESPERA: { id: 'ESPERA', label: 'En espera', color: 'var(--clr-muted)', icon: '⏳' },
    METODO: { id: 'METODO', label: 'Ingresando método', color: 'var(--clr-warning)', icon: '💳' },
    PROCESANDO: { id: 'PROCESANDO', label: 'Procesando pago', color: 'var(--clr-accent)', icon: '⚡' },
    COMPLETADO: { id: 'COMPLETADO', label: 'Reserva confirmada', color: 'var(--clr-success)', icon: '✅' },
    ERROR: { id: 'ERROR', label: 'Error en el pago', color: '#e53935', icon: '❌' },
}

export function transicionar(estadoActual, accion) {
    const transiciones = {
        ESPERA: { INGRESAR_METODO: 'METODO' },
        METODO: { PAGAR: 'PROCESANDO', CANCELAR: 'ESPERA' },
        PROCESANDO: { EXITO: 'COMPLETADO', FALLO: 'ERROR' },
        ERROR: { REINTENTAR: 'METODO' },
    }
    return transiciones[estadoActual]?.[accion] ?? estadoActual
}