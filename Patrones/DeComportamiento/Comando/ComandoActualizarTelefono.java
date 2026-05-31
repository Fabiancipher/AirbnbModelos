package DeComportamiento.Comando;

import Estructura.Usuario;

public class ComandoActualizarTelefono implements Comando {
    private Usuario usuario;
    private String nuevoTelefono;
    private String telefonoAnterior;

    public ComandoActualizarTelefono(Usuario usuario, String nuevoTelefono) {
        this.usuario = usuario;
        this.nuevoTelefono = nuevoTelefono;
    }

    @Override
    public void ejecutar() {
        this.telefonoAnterior = usuario.getTelefono();
        usuario.setTelefono(nuevoTelefono);
        System.out.println("Teléfono actualizado a: " + nuevoTelefono);
    }

    @Override
    public void deshacer() {
        if (telefonoAnterior != null) {
            usuario.setTelefono(telefonoAnterior);
            System.out.println("Teléfono restaurado a: " + telefonoAnterior);
        }
    }
}