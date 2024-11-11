import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class Dataset {

    public List<Datos> Llenado(String filePath) throws IOException{

        List<Datos> datos =new ArrayList<>();

        try(BufferedReader br= new BufferedReader(new FileReader(filePath))){
            String line;
            boolean primeraFila = true;
            while ((line = br.readLine()) != null){
                if(primeraFila){
                    primeraFila = false;
                    continue;
                }
                String[] columna = line.split(",");
                try{
                    int age = Integer.parseInt(columna[0]);
                    int educationalNum = Integer.parseInt(columna[4]);
                    String education = columna[3];
                    int horas_trabajo= Integer.parseInt(columna[12]);

                    datos.add(new Datos( age, educationalNum, education,horas_trabajo));
                } catch (NumberFormatException e){
                    System.err.println("Error con los datos");
                }
            }

        }
        return datos;
    }

}
