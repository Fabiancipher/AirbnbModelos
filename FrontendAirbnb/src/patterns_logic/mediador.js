// PATRÓN: Mediator – el chat coordina mensajes entre Huésped y Anfitrión

export class ChatMediator {
    constructor() {
        this.mensajes = []
        this.listeners = []
    }

    suscribir(fn) { this.listeners.push(fn) }
    notificar() { this.listeners.forEach(fn => fn([...this.mensajes])) }

    enviar(remitente, texto) {
        const msg = { id: Date.now(), remitente, texto, hora: new Date().toLocaleTimeString('es-CO', { hour: '2-digit', minute: '2-digit' }) }
        this.mensajes.push(msg)
        this.notificar()
    }
}

export const chatGlobal = new ChatMediator()