// Patrones: Decorator, Visitor, Facade, Chain of Responsibility, State, Template Method, Adapter
import { useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom'
import { useApp } from '../../context/AppContext'
import { EXTRAS_DISPONIBLES, aplicarDecorador } from '../../patterns_logic/decoradorPrecio'
import { visitanteImpuestos } from '../../patterns_logic/visitante'
import { ejecutarCadena, PASOS_VALIDACION } from '../../patterns_logic/chainOfResponsibility'
import { ESTADOS, transicionar } from '../../patterns_logic/estadoPago'
import styles from './Checkout.module.css'

// Adaptador Stripe simulado
const StripeAdapter = {
    tokenizar: (datos) => `tok_${Math.random().toString(36).slice(2, 10).toUpperCase()}`,
    validar: (token) => token.startsWith('tok_'),
}

export default function Checkout() {
    const { state } = useLocation()
    const navigate = useNavigate()
    const { addNotificacion } = useApp()

    const reserva = state?.reserva
    const [extras, setExtras] = useState([])
    const [estadoId, setEstadoId] = useState('ESPERA')
    const [pasosEstado, setPasosEstado] = useState({})
    const [pasoActual, setPasoActual] = useState(null)
    const [tarjeta, setTarjeta] = useState({ numero: '', venc: '', cvv: '', nombre: '' })
    const [token, setToken] = useState(null)
    const [showModal, setShowModal] = useState(false)

    if (!reserva) return <div className="page"><p style={{ color: 'var(--clr-muted)' }}>No hay reserva activa. <button className="btn btn-ghost" onClick={() => navigate('/')}>Volver</button></p></div>

    const { precioFinal: precioConExtras, detalle: detalleExtras } = aplicarDecorador(reserva.precioBase, extras)

    // Visitor: impuestos según tipo
    const esCabana = reserva.alojamiento?.tipo === 'playa'
    const impInfo = esCabana
        ? visitanteImpuestos.visitarCabana(precioConExtras)
        : visitanteImpuestos.visitarApartamento(precioConExtras)

    const precioTotal = precioConExtras + impInfo.total

    const toggleExtra = (key) =>
        setExtras(prev => prev.includes(key) ? prev.filter(e => e !== key) : [...prev, key])

    // Facade: reserva rápida
    const reservaRapida = async () => {
        setEstadoId('PROCESANDO')
        setShowModal(true)
        const ok = await ejecutarCadena(
            (id) => { setPasoActual(id); setPasosEstado(p => ({ ...p, [id]: 'activo' })) },
            (id) => setPasosEstado(p => ({ ...p, [id]: 'ok' })),
            (id, msg) => { setPasosEstado(p => ({ ...p, [id]: 'error' })); addNotificacion(msg, 'warning') }
        )
        setEstadoId(ok ? 'COMPLETADO' : 'ERROR')
        if (ok) addNotificacion('🎉 ¡Reserva confirmada con éxito!', 'success')
    }

    const iniciarPago = () => {
        const t = StripeAdapter.tokenizar(tarjeta)
        setToken(t)
        addNotificacion(`💳 Token generado: ${t}`, 'info')
        setEstadoId(transicionar(estadoId, 'PAGAR'))
        reservaRapida()
    }

    const estado = ESTADOS[estadoId]

    return (
        <div className="page">
            <p className="tag tag-accent" style={{ marginBottom: 16 }}>🛒 Checkout – 6 Patrones activos</p>
            <h1 className="section-title" style={{ marginBottom: 32 }}>Confirmar reserva</h1>

            <div className={styles.grid}>
                {/* Izquierda */}
                <div style={{ display: 'flex', flexDirection: 'column', gap: 24 }}>

                    {/* Decorator */}
                    <div className="card" style={{ padding: 24 }}>
                        <p className="tag tag-gold" style={{ marginBottom: 14 }}>🎨 Decorator – Extras sobre precio base</p>
                        <div className={styles.extrasGrid}>
                            {Object.entries(EXTRAS_DISPONIBLES).map(([key, extra]) => (
                                <label key={key} className={`${styles.extraItem} ${extras.includes(key) ? styles.extraSel : ''}`}>
                                    <input type="checkbox" checked={extras.includes(key)} onChange={() => toggleExtra(key)} />
                                    <span className={styles.extraIcon}>{extra.icon}</span>
                                    <div>
                                        <div style={{ fontSize: '0.88rem', fontWeight: 500 }}>{extra.label}</div>
                                        <div style={{ fontSize: '0.8rem', color: 'var(--clr-accent)' }}>+${extra.precio.toLocaleString('es-CO')}</div>
                                    </div>
                                </label>
                            ))}
                        </div>
                    </div>

                    {/* State: indicador */}
                    <div className="card" style={{ padding: 24 }}>
                        <p className="tag tag-gold" style={{ marginBottom: 14 }}>⚙️ State – Estado del pago</p>
                        <div className={styles.estadoBar}>
                            {Object.values(ESTADOS).filter(e => !['ERROR'].includes(e.id)).map(e => (
                                <div key={e.id} className={`${styles.estadoStep} ${estadoId === e.id ? styles.estadoActivo : ''}`}
                                    style={{ '--est-color': e.color }}>
                                    <span>{e.icon}</span>
                                    <span style={{ fontSize: '0.72rem' }}>{e.label}</span>
                                </div>
                            ))}
                        </div>
                    </div>

                    {/* Adapter: formulario Stripe */}
                    {estadoId === 'ESPERA' && (
                        <div className="card" style={{ padding: 24 }}>
                            <p className="tag tag-gold" style={{ marginBottom: 14 }}>🔌 Adapter – StripeAdapter (simulado)</p>
                            <div style={{ display: 'grid', gap: 12 }}>
                                <div><label>Nombre en tarjeta</label><input placeholder="JUAN PEREZ" value={tarjeta.nombre} onChange={e => setTarjeta(p => ({ ...p, nombre: e.target.value }))} /></div>
                                <div><label>Número de tarjeta</label><input placeholder="4242 4242 4242 4242" maxLength={19} value={tarjeta.numero} onChange={e => setTarjeta(p => ({ ...p, numero: e.target.value }))} /></div>
                                <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 12 }}>
                                    <div><label>Vencimiento</label><input placeholder="MM/AA" maxLength={5} value={tarjeta.venc} onChange={e => setTarjeta(p => ({ ...p, venc: e.target.value }))} /></div>
                                    <div><label>CVV</label><input placeholder="123" maxLength={3} value={tarjeta.cvv} onChange={e => setTarjeta(p => ({ ...p, cvv: e.target.value }))} /></div>
                                </div>
                            </div>
                            <div style={{ display: 'flex', gap: 10, marginTop: 20 }}>
                                <button className="btn btn-primary" style={{ flex: 1 }} onClick={iniciarPago}>
                                    💳 Pagar ${precioTotal.toLocaleString('es-CO')}
                                </button>
                                <button className="btn btn-gold" onClick={reservaRapida} title="Facade – Reserva rápida">
                                    ⚡ 1-Clic
                                </button>
                            </div>
                        </div>
                    )}
                </div>

                {/* Resumen */}
                <div className="card" style={{ padding: 24, alignSelf: 'start' }}>
                    <h3 style={{ fontFamily: 'var(--font-display)', fontSize: '1.4rem', fontWeight: 400, marginBottom: 20 }}>
                        Resumen de reserva
                    </h3>

                    <div className={styles.resumenRow}><span>🏠 Alojamiento</span><strong>{reserva.alojamiento?.nombre}</strong></div>
                    {reserva.experiencia?.id !== 'ninguna' && <div className={styles.resumenRow}><span>🗺️ Experiencia</span><span>{reserva.experiencia?.label}</span></div>}
                    {reserva.servicio?.id !== 'ninguno' && <div className={styles.resumenRow}><span>🛎️ Servicio</span><span>{reserva.servicio?.label}</span></div>}
                    <div className={styles.resumenRow}><span>📅 Entrada</span><span>{reserva.fechaEntrada || '—'}</span></div>
                    <div className={styles.resumenRow}><span>📅 Salida</span><span>{reserva.fechaSalida || '—'}</span></div>

                    <div style={{ borderTop: '1px solid var(--clr-border)', marginTop: 16, paddingTop: 16 }}>
                        <p className="tag tag-gold" style={{ marginBottom: 10 }}>👁️ Visitor – Desglose de impuestos</p>
                        <div className={styles.resumenRow}><span>Base</span><span>${reserva.precioBase?.toLocaleString('es-CO')}</span></div>
                        {detalleExtras.map(e => <div key={e.key} className={styles.resumenRow}><span>{e.icon} {e.label}</span><span>+${e.precio.toLocaleString('es-CO')}</span></div>)}
                        {impInfo.detalles.map(d => <div key={d.label} className={styles.resumenRow} style={{ color: 'var(--clr-muted)', fontSize: '0.82rem' }}><span>{d.label}</span><span>+${Math.round(d.valor).toLocaleString('es-CO')}</span></div>)}
                        <div className={styles.totalFinal}>
                            <span>Total</span>
                            <span>${Math.round(precioTotal).toLocaleString('es-CO')}</span>
                        </div>
                    </div>
                </div>
            </div>

            {/* Modal: Chain of Responsibility */}
            {showModal && (
                <div className="modal-overlay" onClick={() => estadoId === 'COMPLETADO' && setShowModal(false)}>
                    <div className="modal-box" onClick={e => e.stopPropagation()}>
                        <p className="tag tag-accent" style={{ marginBottom: 16 }}>⛓️ Chain of Responsibility + Template Method</p>
                        <h3 style={{ fontFamily: 'var(--font-display)', fontSize: '1.6rem', fontWeight: 300, marginBottom: 24 }}>Procesando reserva</h3>
                        {PASOS_VALIDACION.map(paso => {
                            const est = pasosEstado[paso.id]
                            return (
                                <div key={paso.id} className={styles.chainPaso} style={{ opacity: est ? 1 : 0.35 }}>
                                    <span className={`${styles.chainIcon} ${est === 'ok' ? styles.chainOk : est === 'activo' ? styles.chainActivo : ''}`}>
                                        {est === 'ok' ? '✓' : est === 'activo' ? '⟳' : '○'}
                                    </span>
                                    <span style={{ fontSize: '0.9rem' }}>{paso.label}</span>
                                </div>
                            )
                        })}
                        {estadoId === 'COMPLETADO' && (
                            <div style={{ marginTop: 24, textAlign: 'center' }}>
                                <p style={{ fontSize: '2rem', marginBottom: 8 }}>🎉</p>
                                <p style={{ color: 'var(--clr-success)', fontWeight: 500 }}>¡Reserva confirmada!</p>
                                <button className="btn btn-primary" style={{ marginTop: 16 }} onClick={() => { setShowModal(false); navigate('/') }}>
                                    Volver al inicio
                                </button>
                            </div>
                        )}
                    </div>
                </div>
            )}
        </div>
    )
}