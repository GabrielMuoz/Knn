import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\Knn-Kmeans\\KNN-AA\\src\\adult.csv";

        Dataset datasetObj = new Dataset();
        List<Datos> dataset = null;
        try {
            dataset = datasetObj.Llenado(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int k = 3;
        Clasificacion clasificacion = new Clasificacion(dataset, null, k);

        // puntos aleatorios
        List<Datos> puntosAleatorios = clasificacion.generarPuntosAleatorios(5);

        // clasificar los puntos
        for (Datos punto : puntosAleatorios) {
            String etiqueta = clasificacion.clasificar(punto);
            System.out.println("Punto: " + punto + " -> Clasificación: " + etiqueta);
        }
    }
}