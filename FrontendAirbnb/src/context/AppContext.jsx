// PATRÓN: Singleton (instancia única del estado global)
import { createContext, useContext, useState, useRef } from 'react'
import { alojamientos as data } from '../patterns_logic/catalogoSingleton'

const AppContext = createContext(null)

export function AppProvider({ children }) {
    // Singleton: una sola instancia del catálogo
    const catalogoRef = useRef(data)
    const [favoritos, setFavoritos] = useState([])
    const [usuario, setUsuario] = useState({ nombre: 'Viajero', email: 'viajero@mail.com', telefono: '+57 300 000000', notificaciones: true })
    const [notificaciones, setNotificaciones] = useState([])
    const [tema, setTema] = useState('dark')

    const addNotificacion = (msg, tipo = 'info') => {
        const id = Date.now()
        setNotificaciones(prev => [...prev, { id, msg, tipo }])
        setTimeout(() => setNotificaciones(prev => prev.filter(n => n.id !== id)), 4000)
    }

    const toggleFavorito = (id) => {
        setFavoritos(prev =>
            prev.includes(id) ? prev.filter(f => f !== id) : [...prev, id]
        )
        addNotificacion(
            favoritos.includes(id) ? 'Eliminado de favoritos' : '❤️ Añadido a favoritos',
            favoritos.includes(id) ? 'warning' : 'success'
        )
    }

    return (
        <AppContext.Provider value={{
            catalogo: catalogoRef.current,
            favoritos, toggleFavorito,
            usuario, setUsuario,
            notificaciones, addNotificacion,
            tema, setTema
        }}>
            {children}
            {/* Toast notifications */}
            <div style={{ position: 'fixed', bottom: 24, right: 24, zIndex: 9999, display: 'flex', flexDirection: 'column', gap: 10 }}>
                {notificaciones.map(n => (
                    <div key={n.id} style={{
                        background: n.tipo === 'success' ? 'var(--clr-success)' : n.tipo === 'warning' ? 'var(--clr-warning)' : 'var(--clr-surface)',
                        color: '#fff', padding: '12px 20px', borderRadius: 'var(--radius-md)',
                        fontSize: '0.85rem', fontFamily: 'var(--font-body)',
                        boxShadow: 'var(--shadow-card)', animation: 'fadeUp 0.3s ease',
                        border: '1px solid var(--clr-border)', maxWidth: 280
                    }}>
                        {n.msg}
                    </div>
                ))}
            </div>
        </AppContext.Provider>
    )
}

export const useApp = () => useContext(AppContext)