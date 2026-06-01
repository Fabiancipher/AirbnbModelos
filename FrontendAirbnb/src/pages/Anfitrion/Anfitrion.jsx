// Patrones: Memento (undo/redo anuncio), Prototipo (clonar), Flyweight (amenidades)
import { useState, useRef } from 'react'
import { MementoManager } from '../../patterns_logic/mementoManager'
import { clonarAnuncio } from '../../patterns_logic/prototipo'
import { AMENIDADES_DISPONIBLES, getAmenidad } from '../../patterns_logic/flyweight'
import { useApp } from '../../context/AppContext'
import styles from './Anfitrion.module.css'

const ANUNCIO_INICIAL = { id: 1, nombre: 'Mi Apartamento Centro', precio: 180000, descripcion: 'Hermoso apartamento en el centro histórico.', amenidades: ['wifi', 'cocina'] }

export default function Anfitrion() {
    const { addNotificacion } = useApp()
    const [anuncios, setAnuncios] = useState([{ ...ANUNCIO_INICIAL }])
    const [selIdx, setSelIdx] = useState(0)
    const mementoRef = useRef(new MementoManager(ANUNCIO_INICIAL))
    const [, forceRender] = useState(0)

    const anuncio = anuncios[selIdx]

    const actualizar = (campo, valor) => {
        const nuevo = { ...anuncio, [campo]: valor }
        const copia = anuncios.map((a, i) => i === selIdx ? nuevo : a)
        setAnuncios(copia)
        mementoRef.current.guardar(nuevo)
        forceRender(n => n + 1)
    }

    const deshacer = () => {
        if (!mementoRef.current.puedeDeshacer()) return
        const restaurado = mementoRef.current.deshacer()
        setAnuncios(prev => prev.map((a, i) => i === selIdx ? restaurado : a))
        forceRender(n => n + 1)
    }

    const rehacer = () => {
        if (!mementoRef.current.puedeRehacer()) return
        const restaurado = mementoRef.current.rehacer()
        setAnuncios(prev => prev.map((a, i) => i === selIdx ? restaurado : a))
        forceRender(n => n + 1)
    }

    const duplicar = () => {
        const clon = clonarAnuncio(anuncio)
        setAnuncios(prev => [...prev, clon])
        mementoRef.current = new MementoManager(clon)
        setSelIdx(anuncios.length)
        addNotificacion('🗂️ Prototipo: Anuncio duplicado', 'success')
        forceRender(n => n + 1)
    }

    const toggleAmenidad = (key) => {
        const nuevas = anuncio.amenidades.includes(key)
            ? anuncio.amenidades.filter(a => a !== key)
            : [...anuncio.amenidades, key]
        actualizar('amenidades', nuevas)
    }

    return (
        <div className="page">
            <p className="tag tag-accent" style={{ marginBottom: 12 }}>🏠 Panel Anfitrión – Memento + Prototipo + Flyweight</p>
            <h1 className="section-title">Mis anuncios</h1>
            <p className="section-sub">Edita, deshaz cambios o duplica tus propiedades.</p>

            <div className={styles.grid}>
                {/* Lista de anuncios */}
                <div>
                    <div className={styles.listaHeader}>
                        <span style={{ color: 'var(--clr-muted)', fontSize: '0.85rem' }}>{anuncios.length} anuncio(s)</span>
                        <button className="btn btn-ghost" style={{ fontSize: '0.82rem', padding: '8px 14px' }} onClick={duplicar}>
                            📋 Duplicar (Prototipo)
                        </button>
                    </div>
                    <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
                        {anuncios.map((a, i) => (
                            <div key={a.id} className={`${styles.anuncioItem} ${selIdx === i ? styles.anuncioSel : ''}`}
                                onClick={() => { setSelIdx(i); mementoRef.current = new MementoManager(a); forceRender(n => n + 1) }}>
                                <div style={{ fontWeight: 500, fontSize: '0.9rem' }}>{a.nombre}</div>
                                <div style={{ color: 'var(--clr-muted)', fontSize: '0.8rem' }}>${a.precio.toLocaleString('es-CO')} / noche</div>
                            </div>
                        ))}
                    </div>
                </div>

                {/* Editor con Memento */}
                <div className="card" style={{ padding: 28 }}>
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 20 }}>
                        <p className="tag tag-gold">💾 Memento – Undo/Redo</p>
                        <div style={{ display: 'flex', gap: 8 }}>
                            <button className="btn btn-ghost" style={{ padding: '8px 14px', fontSize: '0.82rem' }}
                                onClick={deshacer} disabled={!mementoRef.current.puedeDeshacer()}>↩ Deshacer</button>
                            <button className="btn btn-ghost" style={{ padding: '8px 14px', fontSize: '0.82rem' }}
                                onClick={rehacer} disabled={!mementoRef.current.puedeRehacer()}>↪ Rehacer</button>
                        </div>
                    </div>

                    <div style={{ display: 'grid', gap: 16 }}>
                        <div>
                            <label>Nombre del anuncio</label>
                            <input value={anuncio.nombre}
                                onChange={e => actualizar('nombre', e.target.value)} />
                        </div>
                        <div>
                            <label>Precio por noche (COP)</label>
                            <input type="number" value={anuncio.precio}
                                onChange={e => actualizar('precio', Number(e.target.value))} />
                        </div>
                        <div>
                            <label>Descripción</label>
                            <textarea rows={3} value={anuncio.descripcion}
                                onChange={e => actualizar('descripcion', e.target.value)} />
                        </div>

                        {/* Flyweight: amenidades desde pool compartido */}
                        <div>
                            <p className="tag tag-gold" style={{ marginBottom: 10 }}>🪶 Flyweight – Pool de amenidades</p>
                            <div className={styles.amenGrid}>
                                {AMENIDADES_DISPONIBLES.map(a => {
                                    const flyObj = getAmenidad(a.key) // reutiliza del pool
                                    const sel = anuncio.amenidades.includes(a.key)
                                    return (
                                        <button key={a.key}
                                            className={`${styles.amenBtn} ${sel ? styles.amenSel : ''}`}
                                            onClick={() => toggleAmenidad(a.key)}>
                                            {flyObj.icon} {flyObj.label}
                                        </button>
                                    )
                                })}
                            </div>
                        </div>
                    </div>

                    <div className={styles.previewCard}>
                        <p style={{ fontFamily: 'var(--font-display)', fontSize: '1.2rem', marginBottom: 4 }}>{anuncio.nombre}</p>
                        <p style={{ color: 'var(--clr-muted)', fontSize: '0.82rem', marginBottom: 8 }}>{anuncio.descripcion}</p>
                        <div style={{ display: 'flex', gap: 6, flexWrap: 'wrap' }}>
                            {anuncio.amenidades.map(k => { const a = getAmenidad(k); return <span key={k} className="tag">{a.icon} {a.label}</span> })}
                        </div>
                        <p style={{ marginTop: 12, fontFamily: 'var(--font-display)', fontSize: '1.5rem' }}>${anuncio.precio.toLocaleString('es-CO')}<span style={{ fontSize: '0.85rem', color: 'var(--clr-muted)' }}>/noche</span></p>
                    </div>
                </div>
            </div>
        </div>
    )
}