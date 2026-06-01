import { Link, useLocation } from 'react-router-dom'
import { useApp } from '../../context/AppContext'
import styles from './Navbar.module.css'

const LINKS = [
    { to: '/', label: 'Inicio' },
    { to: '/anfitrion', label: 'Anfitrión' },
    { to: '/perfil', label: 'Perfil' },
    { to: '/chat', label: 'Chat' },
]

export default function Navbar() {
    const { favoritos } = useApp()
    const loc = useLocation()

    return (
        <nav className={styles.nav}>
            <Link to="/" className={styles.brand}>
                <span className={styles.brandIcon}>◈</span>
                <span className={styles.brandName}>Airbnb<em>Patterns</em></span>
            </Link>

            <div className={styles.links}>
                {LINKS.map(l => (
                    <Link key={l.to} to={l.to} className={`${styles.link} ${loc.pathname === l.to ? styles.active : ''}`}>
                        {l.label}
                    </Link>
                ))}
            </div>

            <div className={styles.actions}>
                <span className={styles.favBadge}>
                    ❤️ <span>{favoritos.length}</span>
                </span>
                <Link to="/perfil" className={styles.avatar}>V</Link>
            </div>
        </nav>
    )
}