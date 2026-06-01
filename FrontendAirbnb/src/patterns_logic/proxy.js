// PATRÓN: Proxy – valida y controla el acceso antes de ejecutar
export function validarRegistro(datos) {
    const errores = {}

    if (!datos.nombre?.trim())
        errores.nombre = 'El nombre es requerido'
    else if (datos.nombre.length > 50)
        errores.nombre = 'El nombre no puede superar 50 caracteres'

    if (!datos.email?.includes('@'))
        errores.email = 'Email inválido'

    if (!datos.telefono || datos.telefono.replace(/\D/g, '').length < 7)
        errores.telefono = 'Teléfono inválido'

    return { valido: Object.keys(errores).length === 0, errores }
}