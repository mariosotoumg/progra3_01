package cajero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase Crédito, esta clase realiza la consulta y verificacion necesaria del
 * credito de los clientes por medio de su numero de nit.
 */
public class Credito {

    /**
     * Método saldo, en este método se busca el saldo del cliente a través del
     * nit para verificar si es posible que el cliente puede seguir con su crédito
     * local o no tiene suficiente, en este método tiene su propio archivo de texto
     * para llevar el registro de la linea de credito de los clientes.
     *
     * @param nit
     * @return
     * @throws Exception
     */
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

    public void debito(String nit,String monto){
        String linea;
        try {
            BufferedWriter efectivoA  = new BufferedWriter(new FileWriter("credito.txt",true));

            linea = nit + "|" + String.valueOf(monto)+"|0\n";
            efectivoA.write(linea);
            efectivoA.newLine();
            efectivoA.flush();
            efectivoA.close();
        } catch (IOException ex) {
            // nop
        }

    }


}
