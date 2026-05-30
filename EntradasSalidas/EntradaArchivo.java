package EntradasSalidas;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Representa una entrada de datos a través de un archivo. Implementa la interfaz Entrada.
 */
public class EntradaArchivo implements Entrada {

    BufferedReader lector;
    StringBuilder sb = new StringBuilder();

    public EntradaArchivo() {

        try {
            this.lector = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream("archivo.txt"))));

        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e);
        }

    }

    /**
     * Lee el archivo linea por linea y retorna el contenido del archivo como un string
     */
    @Override
    public String capturar(){
        String linea;
        try {
            while ((linea = this.lector.readLine())!=null) {
                 this.sb.append(linea).append("\n");

            }
        } catch (IOException e) {
            System.err.println(e);
        }

        return this.sb.toString();
    }
}
