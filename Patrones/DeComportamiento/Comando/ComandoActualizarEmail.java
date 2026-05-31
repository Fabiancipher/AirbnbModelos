package DeComportamiento.Comando;

import Estructura.Usuario;

public class ComandoActualizarEmail implements Comando {
    private Usuario usuario;
    private String nuevoEmail;
    private String emailAnterior;

    public ComandoActualizarEmail(Usuario usuario, String nuevoEmail) {
        this.usuario = usuario;
        this.nuevoEmail = nuevoEmail;
    }

    @Override
    public void ejecutar() {
        this.emailAnterior = usuario.getEmail();
        usuario.setEmail(nuevoEmail);
        System.out.println("Email actualizado a: " + nuevoEmail);
    }

    @Override
    public void deshacer() {
        if (emailAnterior != null) {
            usuario.setEmail(emailAnterior);
            System.out.println("Email restaurado a: " + emailAnterior);
        }
    }
}