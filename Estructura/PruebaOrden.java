import java.util.Random;
public class PruebaOrden{
    public static void main(String[] args) {
        Casa c1 = new Casa(12, "Barranquilla");
        Casa c2 = new Casa(10, "Cartagena");
        Casa c3 = new Casa(15, "Santa Marta");

        for(int i = 0; i < 5; i++){
            c1.addReview(new Random().nextInt(1, 6));
            c2.addReview(new Random().nextInt(1, 6));
            c3.addReview(new Random().nextInt(1, 6));
        }

        ListaCasas lc = new ListaCasas();
        lc.addCasa(c3);
        lc.addCasa(c2);
        lc.addCasa(c1);

        lc.setSorter(new PorPrecio());

        System.out.println("Antes de ordenar:");
        System.out.println(lc);

        lc.ordenar();

        System.out.println("Después de ordenar(Precio):");
        System.out.println(lc);

        lc.setSorter(new PorReview());
        lc.ordenar();

        System.out.println("Después de ordenar(Review):");
        System.out.println(lc);

        lc.setSorter(new PorLugar());
        lc.ordenar();

        System.out.println("Después de ordenar(Lugar):");
        System.out.println(lc);
    }
}