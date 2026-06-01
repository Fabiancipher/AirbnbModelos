package Estructurales.Adaptador;

public class StripeAPI {
    public void chargeCustomer(String customerEmail, double amountInCents, String stripeToken) {
        System.out.println("   [Stripe API]: Conectando a servidores seguros de Stripe...");
        System.out.printf("   [Stripe API]: Cobro realizado a %s por valor de %.0f centavos (Token: %s)%n",
                customerEmail, amountInCents, stripeToken);
        System.out.println("   [Stripe API]: Transacción STRIPE_SUCCESSFUL.");
    }
}
