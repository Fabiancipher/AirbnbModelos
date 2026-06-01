// PATRÓN: Strategy – algoritmos intercambiables de ordenamiento
// PATRÓN: Iterator – recorre la colección con lógica encapsulada

export const estrategias = {
    precio_asc: {
        label: 'Precio: menor a mayor',
        comparar: (a, b) => a.precio - b.precio
    },
    precio_desc: {
        label: 'Precio: mayor a menor',
        comparar: (a, b) => b.precio - a.precio
    },
    reseñas: {
        label: 'Mejor valorados',
        comparar: (a, b) => b.reseñas - a.reseñas
    },
    popularidad: {
        label: 'Más reseñas',
        comparar: (a, b) => b.reseñasCount - a.reseñasCount
    }
}

// Iterator: genera iterador sobre la lista ordenada
export function crearIterador(lista) {
    let index = 0
    return {
        hasNext: () => index < lista.length,
        next: () => lista[index++],
        reset: () => { index = 0 },
        toArray: () => lista
    }
}

export function aplicarEstrategia(lista, estrategiaKey) {
    const est = estrategias[estrategiaKey]
    if (!est) return lista
    return [...lista].sort(est.comparar)
}