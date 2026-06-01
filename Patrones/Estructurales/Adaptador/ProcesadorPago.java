package Estructurales.Adaptador;

import Estructura.Usuario;

public interface ProcesadorPago {
    void debitar(Usuario cliente, double monto);
}
