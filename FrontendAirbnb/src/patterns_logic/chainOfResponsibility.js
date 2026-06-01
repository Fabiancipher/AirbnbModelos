// PATRÓN: Chain of Responsibility – validaciones secuenciales en checkout
// PATRÓN: Template Method – define el esqueleto del proceso de pago

export const PASOS_VALIDACION = [
    { id: 'cliente', label: 'Verificando cliente', duracion: 900 },
    { id: 'disponibilidad', label: 'Verificando disponibilidad', duracion: 1100 },
    { id: 'pago', label: 'Validando método de pago', duracion: 1300 },
    { id: 'confirmacion', label: 'Confirmando reserva', duracion: 800 },
]

// Template Method: pasos obligatorios del proceso
export async function ejecutarCadena(onPasoInicio, onPasoFin, onError) {
    for (const paso of PASOS_VALIDACION) {
        onPasoInicio(paso.id)
        await delay(paso.duracion)
        // Simulamos fallo aleatorio controlado (0% en demo)
        const falla = false
        if (falla) {
            onError(paso.id, 'Error en ' + paso.label)
            return false
        }
        onPasoFin(paso.id)
    }
    return true
}

const delay = ms => new Promise(res => setTimeout(res, ms))