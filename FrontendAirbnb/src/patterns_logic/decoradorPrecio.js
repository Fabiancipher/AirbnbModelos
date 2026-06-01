// PATRÓN: Decorator – agrega extras al precio base en capas

const EXTRAS = {
    limpieza: { label: 'Servicio de limpieza', precio: 45000, icon: '🧹' },
    mascotas: { label: 'Se admiten mascotas', precio: 30000, icon: '🐾' },
    checkin_tarde: { label: 'Check-in tardío (22h+)', precio: 25000, icon: '🌙' },
    desayuno: { label: 'Desayuno incluido', precio: 55000, icon: '☕' },
    transporte: { label: 'Transporte al aeropuerto', precio: 80000, icon: '🚗' },
}

export function aplicarDecorador(precioBase, extrasSeleccionados) {
    let precio = precioBase
    const detalle = []

    for (const key of extrasSeleccionados) {
        const extra = EXTRAS[key]
        if (extra) {
            precio += extra.precio
            detalle.push({ ...extra, key })
        }
    }

    return { precioFinal: precio, detalle }
}

export const EXTRAS_DISPONIBLES = EXTRAS