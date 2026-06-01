// PATRÓN: Flyweight – pool de amenidades compartidas (no se duplican en memoria)
const _pool = {}

const AMENIDADES_BASE = [
    { key: 'wifi', label: 'WiFi', icon: '📶' },
    { key: 'piscina', label: 'Piscina', icon: '🏊' },
    { key: 'cocina', label: 'Cocina equipada', icon: '🍳' },
    { key: 'ac', label: 'Aire acondicionado', icon: '❄️' },
    { key: 'gym', label: 'Gimnasio', icon: '💪' },
    { key: 'bbq', label: 'Parrilla BBQ', icon: '🔥' },
    { key: 'parking', label: 'Parqueadero', icon: '🅿️' },
    { key: 'pet', label: 'Pet friendly', icon: '🐾' },
]

export function getAmenidad(key) {
    if (!_pool[key]) {
        const found = AMENIDADES_BASE.find(a => a.key === key)
        _pool[key] = found ?? { key, label: key, icon: '•' }
    }
    return _pool[key]
}

export const AMENIDADES_DISPONIBLES = AMENIDADES_BASE