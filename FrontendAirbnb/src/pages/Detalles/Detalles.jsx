// Patrones: Observer (favoritos), Builder (wizard de reserva), Factory Method + Bridge (notificaciones)
import { useState } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import { useApp } from '../../context/AppContext'
import { ReservaBuilder } from '../../patterns_logic/reservaBuilder'
import styles from './Detalles.module.css'

const EXPERIENCIAS = [
    { id: 'ninguna', label: 'Sin experiencia', precio: 0, icon: '—' },
    { id: 'city_tour', label: 'City Tour guiado', precio: 120000, icon: '🗺️' },
    { id: 'gastro', label: 'Tour gastronómico', precio: 90000, icon: '🍽️' },
    { id: 'aventura', label: 'Aventura en naturaleza', precio: 150000, icon: '🏕️' },
]
const SERVICIOS = [
    { id: 'ninguno', label: 'Sin servicio adicional', precio: 0, icon: '—' },
    { id: 'transfer', label: 'Transfer aeropuerto', precio: 80000, icon: '✈️' },
    { id: 'chef', label: 'Chef privado', precio: 200000, icon: '👨‍🍳' },
]

const builder = new ReservaBuilder()

export default function Detalles() {
    const { id } = useParams()
    const navigate = useNavigate()
    const { catalogo, favoritos, toggleFavorito, addNotificacion } = useApp()

    const aloj = catalogo.find(a => a.id === Number(id))
    const [paso, setPaso] = useState(1)
    const [expSel, setExpSel] = useState('ninguna')
    const [srvSel, setSrvSel] = useState('ninguno')
    const [entrada, setEntrada] = useState('')
    const [salida, setSalida] = useState('')
    const [huespedes, setHuespedes] = useState(1)

    if (!aloj) return <div className="page"><p style={{ color: 'var(--clr-muted)' }}>Alojamiento no encontrado.</p></div>

    const esFav = favoritos.includes(aloj.id)

    // Observer: simula notificaciones por cambio de precio
    const simularCambioPrecio = () => {
        addNotificacion('📧 Email: El precio de este alojamiento cambió', 'info')
        setTimeout(() => addNotificacion('📱 Push: ¡Nuevo precio disponible!', 'success'), 800)
    }

    const expObj = EXPERIENCIAS.find(e => e.id === expSel)
    const srvObj = SERVICIOS.find(s => s.id === srvSel)
    const precioTotal = aloj.precio + (expObj?.precio || 0) + (srvObj?.precio || 0)

    const irCheckout = () => {
        builder.setAlojamiento(aloj).setExperiencia(expObj).setServicio(srvObj)
            .setFechas(entrada, salida).setHuespedes(huespedes)
        navigate(`/checkout/${aloj.id}`, { state: { reserva: builder.build() } })
    }

    return (
        <div className="page">
            <div className={styles.grid}>
                {/* Imagen + info */}
                <div>
                    <div className={styles.imgWrap}>
                        <img src={aloj.imagen} alt={aloj.nombre} className={styles.img} />
                        <div className={styles.imgOverlay}>
                            <span className="tag tag-gold">★ {aloj.reseñas} · {aloj.reseñasCount} reseñas</span>
                        </div>
                    </div>
                    <div style={{ marginTop: 24 }}>
                        <p className="tag tag-accent" style={{ marginBottom: 8 }}>👁️ Observer + Factory Method + Bridge</p>
                        <p style={{ color: 'var(--clr-muted)', fontSize: '0.85rem', marginBottom: 12 }}>
                            Suscribirse a cambios de precio genera notificaciones Push y Email como objetos distintos.
                        </p>
                        <div style={{ display: 'flex', gap: 10 }}>
                            <button className={`btn btn-ghost`} onClick={() => toggleFavorito(aloj.id)}>
                                {esFav ? '❤️ En favoritos' : '🤍 Añadir favorito'}
                            </button>
                            <button className="btn btn-ghost" onClick={simularCambioPrecio}>
                                🔔 Simular cambio precio
                            </button>
                        </div>
                    </div>
                </div>

                {/* Builder Wizard */}
                <div>
                    <p className="tag tag-gold" style={{ marginBottom: 12 }}>🏗️ Builder – Wizard de reserva</p>
                    <h1 className={styles.titulo}>{aloj.nombre}</h1>
                    <p style={{ color: 'var(--clr-muted)', marginBottom: 24, fontSize: '0.9rem' }}>{aloj.ubicacion}</p>

                    {/* Paso 1 */}
                    <div className={`${styles.paso} ${paso >= 1 ? styles.pasoActivo : ''}`}>
                        <div className={styles.pasoHeader} onClick={() => setPaso(1)}>
                            <span className={styles.pasoNum}>1</span>
                            <span>Fechas y huéspedes</span>
                            {paso > 1 && <span className="tag tag-success" style={{ marginLeft: 'auto' }}>✓</span>}
                        </div>
                        {paso === 1 && (
                            <div className={styles.pasoBody}>
                                <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 12 }}>
                                    <div><label>Entrada</label><input type="date" value={entrada} onChange={e => setEntrada(e.target.value)} /></div>
                                    <div><label>Salida</label><input type="date" value={salida} onChange={e => setSalida(e.target.value)} /></div>
                                </div>
                                <div style={{ marginTop: 12 }}>
                                    <label>Huéspedes</label>
                                    <input type="number" min="1" max={aloj.huespedes} value={huespedes} onChange={e => setHuespedes(Number(e.target.value))} />
                                </div>
                                <button className="btn btn-primary" style={{ marginTop: 16 }} onClick={() => setPaso(2)}>Continuar →</button>
                            </div>
                        )}
                    </div>

                    {/* Paso 2 */}
                    <div className={`${styles.paso} ${paso >= 2 ? styles.pasoActivo : ''}`}>
                        <div className={styles.pasoHeader} onClick={() => paso > 2 && setPaso(2)}>
                            <span className={styles.pasoNum}>2</span>
                            <span>Agregar experiencia</span>
                            {paso > 2 && <span className="tag tag-success" style={{ marginLeft: 'auto' }}>✓</span>}
                        </div>
                        {paso === 2 && (
                            <div className={styles.pasoBody}>
                                {EXPERIENCIAS.map(e => (
                                    <label key={e.id} className={`${styles.opcion} ${expSel === e.id ? styles.opcionSel : ''}`}>
                                        <input type="radio" name="exp" value={e.id} checked={expSel === e.id} onChange={() => setExpSel(e.id)} />
                                        <span>{e.icon} {e.label}</span>
                                        {e.precio > 0 && <span className={styles.opcionPrecio}>+${e.precio.toLocaleString('es-CO')}</span>}
                                    </label>
                                ))}
                                <div style={{ display: 'flex', gap: 10, marginTop: 12 }}>
                                    <button className="btn btn-ghost" onClick={() => setPaso(1)}>← Atrás</button>
                                    <button className="btn btn-primary" onClick={() => setPaso(3)}>Continuar →</button>
                                </div>
                            </div>
                        )}
                    </div>

                    {/* Paso 3 */}
                    <div className={`${styles.paso} ${paso >= 3 ? styles.pasoActivo : ''}`}>
                        <div className={styles.pasoHeader}>
                            <span className={styles.pasoNum}>3</span>
                            <span>Servicio adicional</span>
                        </div>
                        {paso === 3 && (
                            <div className={styles.pasoBody}>
                                {SERVICIOS.map(s => (
                                    <label key={s.id} className={`${styles.opcion} ${srvSel === s.id ? styles.opcionSel : ''}`}>
                                        <input type="radio" name="srv" value={s.id} checked={srvSel === s.id} onChange={() => setSrvSel(s.id)} />
                                        <span>{s.icon} {s.label}</span>
                                        {s.precio > 0 && <span className={styles.opcionPrecio}>+${s.precio.toLocaleString('es-CO')}</span>}
                                    </label>
                                ))}
                                <div className={styles.totalRow}>
                                    <span>Total estimado</span>
                                    <span className={styles.totalNum}>${precioTotal.toLocaleString('es-CO')}</span>
                                </div>
                                <div style={{ display: 'flex', gap: 10, marginTop: 12 }}>
                                    <button className="btn btn-ghost" onClick={() => setPaso(2)}>← Atrás</button>
                                    <button className="btn btn-primary" onClick={irCheckout}>Ir al checkout →</button>
                                </div>
                            </div>
                        )}
                    </div>
                </div>
            </div>
        </div>
    )
}