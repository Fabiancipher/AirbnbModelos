// PATRÓN: Prototype – clona un anuncio con nuevo ID
export function clonarAnuncio(anuncio) {
    return {
        ...JSON.parse(JSON.stringify(anuncio)),
        id: Date.now(),
        nombre: `${anuncio.nombre} (Copia)`,
        reseñas: 0,
        reseñasCount: 0,
    }
}