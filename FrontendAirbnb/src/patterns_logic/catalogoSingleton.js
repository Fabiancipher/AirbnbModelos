// PATRÓN: Singleton – única fuente de datos del catálogo
let instancia = null

const _data = [
    { id: 1, nombre: 'Villa Horizonte', tipo: 'ciudad', precio: 320000, reseñas: 4.97, reseñasCount: 214, ubicacion: 'Cartagena, Colombia', descripcion: 'Penthouse minimalista con vista panorámica al mar Caribe. Piscina privada y terraza infinita.', imagen: 'https://images.unsplash.com/photo-1512917774080-9991f1c4c750?w=800&q=80', amenidades: ['Piscina', 'WiFi', 'Cocina', 'AC'], huespedes: 4, habitaciones: 2 },
    { id: 2, nombre: 'Casa Cañaveral', tipo: 'playa', precio: 480000, reseñas: 4.89, reseñasCount: 312, ubicacion: 'Santa Marta, Colombia', descripcion: 'Casa de playa privada rodeada de naturaleza. Acceso directo al mar y hamacas entre palmeras.', imagen: 'https://images.unsplash.com/photo-1499793983690-e29da59ef1c2?w=800&q=80', amenidades: ['Playa privada', 'BBQ', 'WiFi', 'Kayak'], huespedes: 6, habitaciones: 3 },
    { id: 3, nombre: 'Loft Candelaria', tipo: 'ciudad', precio: 195000, reseñas: 4.95, reseñasCount: 178, ubicacion: 'Bogotá, Colombia', descripcion: 'Loft de diseño en el corazón histórico. Arte contemporáneo, techos altos y luz natural.', imagen: 'https://images.unsplash.com/photo-1536376072261-38c75010e6c9?w=800&q=80', amenidades: ['WiFi', 'Cocina', 'Workspace', 'Gym'], huespedes: 2, habitaciones: 1 },
    { id: 4, nombre: 'Cabaña Cocora', tipo: 'playa', precio: 260000, reseñas: 5.0, reseñasCount: 89, ubicacion: 'Salento, Colombia', descripcion: 'Cabaña rústica-lujosa en el Valle del Cocora. Rodeada de palmas de cera y neblina matinal.', imagen: 'https://images.unsplash.com/photo-1510798831971-661eb04b3739?w=800&q=80', amenidades: ['Chimenea', 'Desayuno', 'Caballos', 'WiFi'], huespedes: 2, habitaciones: 1 },
    { id: 5, nombre: 'Penthouse Poblado', tipo: 'ciudad', precio: 550000, reseñas: 4.92, reseñasCount: 267, ubicacion: 'Medellín, Colombia', descripcion: 'Penthouse de lujo en El Poblado. Rooftop privado, jacuzzi y vistas a las luces de la ciudad.', imagen: 'https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?w=800&q=80', amenidades: ['Jacuzzi', 'Rooftop', 'Bar', 'Concierge'], huespedes: 4, habitaciones: 2 },
    { id: 6, nombre: 'Eco-Lodge Tayrona', tipo: 'playa', precio: 310000, reseñas: 4.88, reseñasCount: 145, ubicacion: 'Parque Tayrona, Colombia', descripcion: 'Lodge ecológico dentro del parque. Glamping de lujo entre la selva y el Caribe.', imagen: 'https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=800&q=80', amenidades: ['Trekking', 'Snorkel', 'Naturaleza', 'Desayuno'], huespedes: 2, habitaciones: 1 },
]

function getCatalogo() {
    if (!instancia) {
        instancia = _data
    }
    return instancia
}

export const alojamientos = getCatalogo()