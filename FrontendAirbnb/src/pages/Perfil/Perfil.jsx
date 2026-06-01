// Patrones: Proxy (validación), Command (undo/redo edición)
import { useState, useRef } from 'react'
import { useApp } from '../../context/AppContext'
import { CommandManager, crearComandoEdicion } from '../../patterns_logic/commandManager'
import { validarRegistro } from '../../patterns_logic/proxy'
import styles from './Perfil.module.css'

const manager = new CommandManager()

export default function Perfil() {
    const { usuario, setUsuario, addNotificacion } = useApp()
    const [form, setForm] = useState({ ...usuario })
    const [errores, setErrores] = useState({})
    const [, forceRender] = useState(0)

    const guardarCampo = (campo, valor) => {
        const anterior = form[campo]
        if (anterior === valor) return
        const cmd = crearComandoEdicion(campo, anterior, valor, (updater) => {
            setForm(updater)
        })
        manager.ejecutar(cmd)
        forceRender(n => n + 1)
    }

    const deshacer = () => { manager.deshacer(); forceRender(n => n + 1) }
    const rehacer = () => { manager.rehacer(); forceRender(n => n + 1) }

    const guardar = () => {
        // Proxy: valida antes de persistir
        const { valido, errores: errs } = validarRegistro(form)
        setErrores(errs)
        if (!valido) {
            addNotificacion('⛔ Proxy detuvo el guardado: hay errores', 'warning')
            return
        }
        setUsuario(form)
        addNotificacion('✅ Perfil actualizado correctamente', 'success')
    }

    return (
        <div className="page">
            <p className="tag tag-accent" style={{ marginBottom: 12 }}>👤 Perfil – Proxy + Command Undo/Redo</p>
            <h1 className="section-title">Mi perfil</h1>
            <p className="section-sub">Los cambios pasan por el Proxy de validación antes de guardarse.</p>

            <div className={styles.grid}>
                <div className="card" style={{ padding: 32 }}>
                    <div className={styles.avatarZone}>
                        <div className={styles.avatar}>{form.nombre?.[0]?.toUpperCase() || 'U'}</div>
                        <div>
                            <p style={{ fontFamily: 'var(--font-display)', fontSize: '1.5rem' }}>{form.nombre}</p>
                            <p style={{ color: 'var(--clr-muted)', fontSize: '0.85rem' }}>Miembro activo</p>
                        </div>
                    </div>

                    <div style={{ display: 'grid', gap: 18, marginTop: 28 }}>
                        {[
                            { key: 'nombre', label: 'Nombre completo', type: 'text' },
                            { key: 'email', label: 'Correo electrónico', type: 'email' },
                            { key: 'telefono', label: 'Teléfono', type: 'tel' },
                        ].map(({ key, label, type }) => (
                            <div key={key}>
                                <label>{label}</label>
                                <input
                                    type={type} value={form[key]}
                                    onChange={e => setForm(p => ({ ...p, [key]: e.target.value }))}
                                    onBlur={e => guardarCampo(key, e.target.value)}
                                    style={errores[key] ? { borderColor: '#e53935' } : {}}
                                />
                                {errores[key] && <p style={{ color: '#e53935', fontSize: '0.78rem', marginTop: 4 }}>⚠ {errores[key]}</p>}
                            </div>
                        ))}

                        <div>
                            <label>Notificaciones por email</label>
                            <div style={{ display: 'flex', gap: 10, marginTop: 4 }}>
                                {[true, false].map(val => (
                                    <label key={String(val)} style={{ display: 'flex', alignItems: 'center', gap: 8, cursor: 'pointer', fontSize: '0.88rem' }}>
                                        <input type="radio" name="notif" checked={form.notificaciones === val}
                                            onChange={() => { setForm(p => ({ ...p, notificaciones: val })); guardarCampo('notificaciones', val) }} />
                                        {val ? '✅ Activadas' : '🔕 Desactivadas'}
                                    </label>
                                ))}
                            </div>
                        </div>
                    </div>

                    <div style={{ display: 'flex', gap: 10, marginTop: 28 }}>
                        <button className="btn btn-ghost" onClick={deshacer} disabled={!manager.puedeDeshacer()} title="Command: Deshacer">
                            ↩ Deshacer
                        </button>
                        <button className="btn btn-ghost" onClick={rehacer} disabled={!manager.puedeRehacer()} title="Command: Rehacer">
                            ↪ Rehacer
                        </button>
                        <button className="btn btn-primary" style={{ marginLeft: 'auto' }} onClick={guardar}>
                            💾 Guardar (Proxy)
                        </button>
                    </div>
                </div>

                <div className="card" style={{ padding: 24 }}>
                    <p className="tag tag-gold" style={{ marginBottom: 14 }}>📋 Historial de comandos</p>
                    {manager.historial.length === 0
                        ? <p style={{ color: 'var(--clr-muted)', fontSize: '0.85rem' }}>Aún no hay cambios registrados.</p>
                        : manager.historial.map((cmd, i) => (
                            <div key={i} className={styles.cmdItem}
                                style={{ opacity: i <= manager.posicion ? 1 : 0.35 }}>
                                <span className={`tag ${i === manager.posicion ? 'tag-accent' : ''}`}>#{i + 1}</span>
                                <span style={{ fontSize: '0.85rem' }}>{cmd.label}</span>
                                {i === manager.posicion && <span style={{ marginLeft: 'auto', fontSize: '0.75rem', color: 'var(--clr-accent)' }}>← actual</span>}
                            </div>
                        ))
                    }
                </div>
            </div>
        </div>
    )
}