import java.util.ArrayList;
public class Casa{
    private final double precio;
    private final String lugar;
    private final ArrayList<Integer> reviews;

    public Casa(float p, String l){
        precio = p;
        lugar = l;
        reviews = new ArrayList<>();
    }

    public double getPrecio(){
        return precio;
    }

    public String getLugar(){
        return lugar;
    }

    public ArrayList<Integer> getReviews(){
        return reviews;
    }

    public double getPromedioReviews(){
        if(reviews.isEmpty()) return 0;
        int sum = 0;
        for(int r : reviews){
            sum += r;
        }
        return (double)sum / reviews.size();
    }

    public void addReview(int nota){
        reviews.add(nota);
    }

    @Override
    public String toString(){
        return "Casa en " + lugar + " con precio " + precio + "; Promedio de reviews: " + getPromedioReviews();
    }

}