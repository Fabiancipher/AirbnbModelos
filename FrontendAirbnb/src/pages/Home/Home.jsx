// Patrones: Singleton, Abstract Factory, Composite, Strategy, Iterator
import { useState, useMemo } from 'react'
import { useApp } from '../../context/AppContext'
import AlojamientoCard from '../../components/AlojamientoCard/AlojamientoCard'
import { aplicarEstrategia, estrategias } from '../../patterns_logic/estrategias'
import { factories } from '../../patterns_logic/abstractFactory'
import styles from './Home.module.css'

// Composite: árbol de destinos País > Ciudad
const DESTINOS_COMPOSITE = {
    label: '🌎 Colombia',
    children: [
        {
            label: '🏙️ Ciudades', children: [
                { label: 'Bogotá' }, { label: 'Medellín' }, { label: 'Cartagena' }
            ]
        },
        {
            label: '🏖️ Playas', children: [
                { label: 'Santa Marta' }, { label: 'Tayrona' }, { label: 'Salento' }
            ]
        },
    ]
}

function NodoComposite({ nodo, nivel = 0 }) {
    const [open, setOpen] = useState(nivel === 0)
    return (
        <div style={{ paddingLeft: nivel * 14 }}>
            <button onClick={() => setOpen(o => !o)} className={styles.compositeBtn}>
                {nodo.children ? (open ? '▾' : '▸') : '·'} {nodo.label}
            </button>
            {open && nodo.children && nodo.children.map((c, i) => (
                <NodoComposite key={i} nodo={c} nivel={nivel + 1} />
            ))}
        </div>
    )
}

export default function Home() {
    const { catalogo } = useApp()
    const [tipoFactory, setTipoFactory] = useState('todos')
    const [estrategia, setEstrategia] = useState('reseñas')
    const [busqueda, setBusqueda] = useState('')

    const factory = factories[tipoFactory]

    const resultado = useMemo(() => {
        let lista = factory.filtrar(catalogo)
        if (busqueda) lista = lista.filter(a =>
            a.nombre.toLowerCase().includes(busqueda.toLowerCase()) ||
            a.ubicacion.toLowerCase().includes(busqueda.toLowerCase())
        )
        return aplicarEstrategia(lista, estrategia)
    }, [catalogo, tipoFactory, estrategia, busqueda])

    return (
        <div className="page">
            {/* Hero */}
            <div className={styles.hero}>
                <p className="tag tag-accent" style={{ marginBottom: 16 }}>22 Patrones de Diseño · Java → React</p>
                <h1 className={`section-title ${styles.heroTitle}`}>
                    Encontrá tu<br /><em>refugio perfecto</em>
                </h1>
                <p className={styles.heroSub}>Cada interacción demuestra un patrón de diseño en acción.</p>
            </div>

            {/* Composite: árbol de destinos */}
            <div className={styles.panelRow}>
                <div className={`card ${styles.compositePanel}`}>
                    <p className="tag tag-gold" style={{ marginBottom: 12 }}>🌿 Composite – Menú anidado</p>
                    <NodoComposite nodo={DESTINOS_COMPOSITE} />
                </div>

                {/* Abstract Factory */}
                <div className={`card ${styles.factoryPanel}`}>
                    <p className="tag tag-gold" style={{ marginBottom: 12 }}>🏭 Abstract Factory – Tipo de destino</p>
                    <div className={styles.factoryBtns}>
                        {Object.values(factories).map(f => (
                            <button key={f.tipo}
                                className={`btn ${tipoFactory === f.tipo ? 'btn-primary' : 'btn-ghost'}`}
                                onClick={() => setTipoFactory(f.tipo)}
                                style={{ flex: 1 }}>
                                {f.etiqueta}
                            </button>
                        ))}
                    </div>
                    <p style={{ fontSize: '0.8rem', color: 'var(--clr-muted)', marginTop: 10 }}>{factory.descripcionFiltro}</p>
                </div>
            </div>

            {/* Strategy + Search */}
            <div className={styles.toolbar}>
                <input
                    type="text" placeholder="🔍  Buscar destino o alojamiento…"
                    value={busqueda} onChange={e => setBusqueda(e.target.value)}
                    style={{ flex: 1, maxWidth: 420 }}
                />
                <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
                    <span className="tag tag-accent">⚡ Strategy – Iterator</span>
                    <select value={estrategia} onChange={e => setEstrategia(e.target.value)} style={{ width: 220 }}>
                        {Object.entries(estrategias).map(([k, v]) => (
                            <option key={k} value={k}>{v.label}</option>
                        ))}
                    </select>
                </div>
            </div>

            {/* Grid */}
            <div className={styles.grid}>
                {resultado.map(a => <AlojamientoCard key={a.id} aloj={a} />)}
                {resultado.length === 0 && (
                    <p style={{ color: 'var(--clr-muted)', gridColumn: '1/-1', textAlign: 'center', padding: 60 }}>
                        No se encontraron alojamientos.
                    </p>
                )}
            </div>
        </div>
    )
}