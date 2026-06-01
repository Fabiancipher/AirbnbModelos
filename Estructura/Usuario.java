package Estructura;

public class Usuario {
    private String nombre;
    private String email;
    private String telefono;
    private Boolean mostrarNotificaciones;

    public Usuario(String nombre, String email, String telefono, Boolean mostrarNotificaciones) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.mostrarNotificaciones = mostrarNotificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getMostrarNotificaciones() {
        return mostrarNotificaciones;
    }

    public void setMostrarNotificaciones(Boolean mostrarNotificaciones) {
        this.mostrarNotificaciones = mostrarNotificaciones;
    }

    public void cambiarEstadoNotificaciones() {
        this.mostrarNotificaciones = !this.mostrarNotificaciones;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "Nombre='" + nombre + '\'' +
                ", Email='" + email + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Notificaciones=" + (mostrarNotificaciones ? "ACTIVADAS" : "DESACTIVADAS") +
                '}';
    }
}
