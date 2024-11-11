import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Clasificacion {

    public List<Datos> dataset;
    public List<Datos> testset;
    public int k;

    public Clasificacion(List<Datos> dataset, List<Datos> testset, int k) {
        this.dataset = dataset;
        this.testset = testset;
        this.k = k;
    }

    // puntos aleatorios
    public List<Datos> generarPuntosAleatorios(int cantidad) {
        List<Datos> puntosAleatorios = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            int age = 18 + random.nextInt(60);
            int educationalNum = 1 + random.nextInt(20);
            String education = "";
            int horas_trabajo=30+ random.nextInt(60);
            puntosAleatorios.add(new Datos(age, educationalNum, education,horas_trabajo));
        }
        return puntosAleatorios;
    }


    //calcular distancias
    public double calcularDistancia(Datos d1, Datos d2) {
        int ageDiff = d1.getAge() - d2.getAge();
        int educationalNumDiff = d1.getEducationalNum() - d2.getEducationalNum();
        int horasDiff = d1.getHoras_trabajo()- d2.getHoras_trabajo();
        return Math.sqrt(Math.pow(ageDiff, 2) + Math.pow(educationalNumDiff, 2)+Math.pow(horasDiff, 2));
    }

    // arreglo de distancias
    public List<Datos> ordenarPorDistancia(Datos punto) {
        List<Datos> copiaDataset = new ArrayList<>(dataset);
        copiaDataset.sort(Comparator.comparingDouble(d -> calcularDistancia(d, punto)));
        return copiaDataset;
    }

    // clasificar puntos
    public String clasificar(Datos punto) {
        List<Datos> vecinosCercanos = ordenarPorDistancia(punto).subList(0, k);

        // contar clasificaciones frecuentes
        Map<String, Integer> frecuencias = new HashMap<>();
        for (Datos vecino : vecinosCercanos) {
            String etiqueta = vecino.getEducation();
            frecuencias.put(etiqueta, frecuencias.getOrDefault(etiqueta, 0) + 1);
        }

        // sacar la mas frecuente
        String etiquetaMasComun = null;
        int maxFrecuencia = 0;
        for (Map.Entry<String, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                etiquetaMasComun = entry.getKey();
            }
        }

        return etiquetaMasComun != null ? etiquetaMasComun : "Sin clasificación";
    }
}
