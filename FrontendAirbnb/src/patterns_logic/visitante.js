// PATRÓN: Visitor – calcula impuestos según tipo de alojamiento

export const visitanteImpuestos = {
    visitarApartamento(precio) {
        const iva = precio * 0.19
        const turismo = precio * 0.02
        return {
            iva, turismo, total: iva + turismo, detalles: [
                { label: 'IVA (19%)', valor: iva },
                { label: 'Tasa turismo (2%)', valor: turismo },
            ]
        }
    },
    visitarCabana(precio) {
        const iva = precio * 0.05
        const ambiental = precio * 0.01
        return {
            iva, ambiental, total: iva + ambiental, detalles: [
                { label: 'IVA reducido (5%)', valor: iva },
                { label: 'Tasa ambiental (1%)', valor: ambiental },
            ]
        }
    }
}