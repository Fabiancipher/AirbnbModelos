// Patrón: Mediator – coordina mensajes entre Huésped y Anfitrión
import { useState, useEffect, useRef } from 'react'
import { chatGlobal } from '../../patterns_logic/mediador'
import styles from './Chat.module.css'

const BOTS = {
    huesped: { nombre: 'Huésped (Tú)', color: 'var(--clr-accent)', inicial: 'H' },
    anfitrion: { nombre: 'Anfitrión', color: 'var(--clr-gold)', inicial: 'A' },
}

const RESPUESTAS_AUTO = [
    '¡Hola! ¿Cómo puedo ayudarte?',
    '¡Claro! El check-in es a las 3pm.',
    'Sí, aceptamos mascotas con depósito previo.',
    'El parqueadero está disponible sin costo extra.',
    '¡Por supuesto! Te esperamos con gusto.',
]

export default function Chat() {
    const [mensajes, setMensajes] = useState([])
    const [texto, setTexto] = useState('')
    const [remitente, setRemitente] = useState('huesped')
    const bottomRef = useRef(null)

    useEffect(() => {
        chatGlobal.suscribir(msgs => setMensajes(msgs))
        chatGlobal.enviar('anfitrion', '¡Bienvenido! Soy tu anfitrión. ¿En qué te ayudo?')
    }, [])

    useEffect(() => {
        bottomRef.current?.scrollIntoView({ behavior: 'smooth' })
    }, [mensajes])

    const enviar = () => {
        if (!texto.trim()) return
        chatGlobal.enviar(remitente, texto.trim())
        setTexto('')

        // Respuesta automática del otro lado
        if (remitente === 'huesped') {
            setTimeout(() => {
                const resp = RESPUESTAS_AUTO[Math.floor(Math.random() * RESPUESTAS_AUTO.length)]
                chatGlobal.enviar('anfitrion', resp)
            }, 900)
        }
    }

    return (
        <div className="page">
            <p className="tag tag-accent" style={{ marginBottom: 12 }}>💬 Chat – Patrón Mediator</p>
            <h1 className="section-title">Chat Huésped · Anfitrión</h1>
            <p className="section-sub">El Mediador coordina los mensajes sin acoplamiento directo entre actores.</p>

            <div className={styles.layout}>
                {/* Selector de rol */}
                <div className="card" style={{ padding: 20 }}>
                    <p style={{ fontSize: '0.8rem', color: 'var(--clr-muted)', marginBottom: 12, textTransform: 'uppercase', letterSpacing: '0.05em' }}>Hablar como:</p>
                    {Object.entries(BOTS).map(([key, bot]) => (
                        <button key={key} className={`${styles.rolBtn} ${remitente === key ? styles.rolSel : ''}`}
                            onClick={() => setRemitente(key)}
                            style={{ '--bot-color': bot.color }}>
                            <span className={styles.rolAvatar} style={{ background: bot.color }}>{bot.inicial}</span>
                            {bot.nombre}
                        </button>
                    ))}
                </div>

                {/* Ventana de chat */}
                <div className={`card ${styles.chatWin}`}>
                    <div className={styles.chatHeader}>
                        <span style={{ fontFamily: 'var(--font-display)', fontSize: '1.1rem' }}>Conversación activa</span>
                        <span className="tag tag-success">● En línea</span>
                    </div>

                    <div className={styles.mensajes}>
                        {mensajes.map(m => {
                            const bot = BOTS[m.remitente]
                            const esMio = m.remitente === remitente
                            return (
                                <div key={m.id} className={`${styles.msgRow} ${esMio ? styles.msgMio : ''}`}>
                                    {!esMio && <span className={styles.msgAvatar} style={{ background: bot?.color }}>{bot?.inicial}</span>}
                                    <div className={`${styles.bubble} ${esMio ? styles.bubbleMio : ''}`}
                                        style={esMio ? { background: bot?.color } : {}}>
                                        {!esMio && <span className={styles.msgNombre}>{bot?.nombre}</span>}
                                        <p>{m.texto}</p>
                                        <span className={styles.msgHora}>{m.hora}</span>
                                    </div>
                                </div>
                            )
                        })}
                        <div ref={bottomRef} />
                    </div>

                    <div className={styles.inputRow}>
                        <input
                            placeholder="Escribe un mensaje…"
                            value={texto}
                            onChange={e => setTexto(e.target.value)}
                            onKeyDown={e => e.key === 'Enter' && enviar()}
                        />
                        <button className="btn btn-primary" onClick={enviar}>Enviar</button>
                    </div>
                </div>
            </div>
        </div>
    )
}