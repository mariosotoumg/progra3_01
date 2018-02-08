package cajero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Credito {

    public int saldo(String nit) throws Exception{
        String[] registro = new String[3];
        String linea;
        BufferedReader creditoA;
        int cobrado = 0;
        int pagado  = 0;
        try{
            creditoA = new BufferedReader(new FileReader("credito.txt"));
            while ( (linea = creditoA.readLine() ) != null) {
                registro = linea.split("\\|");
                if(nit.compareTo(registro[0]) == 0){
                    cobrado += Integer.parseInt(registro[1]);
                    pagado  += Integer.parseInt(registro[2]);
                }
            }
            creditoA.close();
        } catch (FileNotFoundException ex) {
            throw new Exception("Archivo no encontrado");
        } catch (IOException ex) {
            throw new Exception("Archivo no accesible");
        }
        return pagado-cobrado;
    }



}
