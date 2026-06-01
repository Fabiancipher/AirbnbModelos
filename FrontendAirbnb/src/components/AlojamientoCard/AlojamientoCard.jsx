import { Link } from 'react-router-dom'
import { useApp } from '../../context/AppContext'
import styles from './AlojamientoCard.module.css'

export default function AlojamientoCard({ aloj }) {
    const { favoritos, toggleFavorito } = useApp()
    const esFav = favoritos.includes(aloj.id)

    return (
        <div className={`${styles.card} fade-up`}>
            <div className={styles.imgWrap}>
                <img src={aloj.imagen} alt={aloj.nombre} className={styles.img} loading="lazy" />
                <button className={`${styles.favBtn} ${esFav ? styles.favActive : ''}`}
                    onClick={() => toggleFavorito(aloj.id)} title="Añadir a favoritos">
                    {esFav ? '❤️' : '🤍'}
                </button>
                <span className={`tag ${aloj.tipo === 'playa' ? 'tag-accent' : 'tag-gold'}`} style={{ position: 'absolute', bottom: 12, left: 12 }}>
                    {aloj.tipo === 'playa' ? '🏖️ Playa' : '🏙️ Ciudad'}
                </span>
            </div>

            <div className={styles.body}>
                <div className={styles.meta}>
                    <span className={styles.loc}>📍 {aloj.ubicacion}</span>
                    <span className={styles.rating}>★ {aloj.reseñas} <em>({aloj.reseñasCount})</em></span>
                </div>

                <h3 className={styles.nombre}>{aloj.nombre}</h3>
                <p className={styles.desc}>{aloj.descripcion}</p>

                <div className={styles.amenidades}>
                    {aloj.amenidades.slice(0, 3).map(a => (
                        <span key={a} className="tag">{a}</span>
                    ))}
                </div>

                <div className={styles.footer}>
                    <div className={styles.precio}>
                        <span className={styles.precioNum}>${aloj.precio.toLocaleString('es-CO')}</span>
                        <span className={styles.precioLabel}> / noche</span>
                    </div>
                    <Link to={`/detalles/${aloj.id}`} className="btn btn-primary" style={{ padding: '10px 20px', fontSize: '0.82rem' }}>
                        Ver detalles
                    </Link>
                </div>
            </div>
        </div>
    )
}