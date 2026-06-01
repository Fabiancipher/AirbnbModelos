package Estructurales.Adaptador;

import Estructura.Usuario;

public class StripeAdapter implements ProcesadorPago {
    private StripeAPI stripeAPI;
    private String tokenSimulado;

    public StripeAdapter(StripeAPI stripeAPI, String tokenSimulado) {
        this.stripeAPI = stripeAPI;
        this.tokenSimulado = tokenSimulado;
    }

    @Override
    public void debitar(Usuario cliente, double monto) {
        System.out.println("   [StripeAdapter]: Traduciendo llamada para Stripe...");
        // 1. Obtener email del usuario
        String email = cliente.getEmail();
        // 2. Convertir monto de dólares a centavos
        double montoCentavos = monto * 100.0;
        // 3. Ejecutar cargo en la API externa
        stripeAPI.chargeCustomer(email, montoCentavos, tokenSimulado);
    }
}
