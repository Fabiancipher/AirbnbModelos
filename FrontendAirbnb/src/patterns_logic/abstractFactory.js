// PATRÓN: Abstract Factory – familias de componentes según tipo de destino
export const factoryCiudad = {
    tipo: 'ciudad',
    colorAccent: 'var(--clr-accent)',
    etiqueta: '🏙️ Ciudad',
    descripcionFiltro: 'Alojamientos urbanos y culturales',
    filtrar: (lista) => lista.filter(a => a.tipo === 'ciudad'),
}

export const factoryPlaya = {
    tipo: 'playa',
    colorAccent: '#00b4d8',
    etiqueta: '🏖️ Playa',
    descripcionFiltro: 'Alojamientos junto al mar y naturaleza',
    filtrar: (lista) => lista.filter(a => a.tipo === 'playa'),
}

export const factoryTodos = {
    tipo: 'todos',
    colorAccent: 'var(--clr-gold)',
    etiqueta: '🌎 Todos',
    descripcionFiltro: 'Todos los destinos disponibles',
    filtrar: (lista) => lista,
}

export const factories = { ciudad: factoryCiudad, playa: factoryPlaya, todos: factoryTodos }