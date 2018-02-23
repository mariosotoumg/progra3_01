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
      * La función getCredito, es una función que sirve para buscar el crédito 
      * por medio del String fecha se utiliza un bufferdReader para poder abrir
      * el archivo “crédito.txt” donde se encuentran todos los registro de pago
      * a crédito que se necesitan
      * 
      * @param fecha este String sirve para la búsqueda del crédito 
      * @return este devuelve el resultado del pago si se a logrado hacer todos los procesos exitosamente 
      * @throws Exception 
      */
    public int getCredito(String fecha) throws Exception{
        String[] registro = new String[4];
        String linea;
        BufferedReader creditoA;
        int pagado = 0;
        try{
            creditoA = new BufferedReader(new FileReader("credito.txt"));
            while ( (linea = creditoA.readLine() ) != null) {
                registro = linea.split("\\|");
                if(fecha.compareTo(registro[0]) == 0){
                    pagado  += Integer.parseInt(registro[2]);
                }
            }
            creditoA.close();
        } catch (FileNotFoundException ex) {
            throw new Exception("Archivo no encontrado");
        } catch (IOException ex) {
            throw new Exception("Archivo no accesible");
        }
        return pagado;
    }

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
        String[] registro = new String[4];
        String linea;
        BufferedReader creditoA;
        int cobrado = 0;
        int pagado  = 0;
        try{
            creditoA = new BufferedReader(new FileReader("credito.txt"));
            while ( (linea = creditoA.readLine() ) != null) {
                registro = linea.split("\\|");
                if(nit.compareTo(registro[1]) == 0){
                    cobrado += Integer.parseInt(registro[2]);
                    pagado  += Integer.parseInt(registro[3]);
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

    /**
     * Método debito, en este método registra la fecha de la operacion
     * asi como el numero de nit del cliente y el monto que esta quedando
     * como credito que se le otroga al cliente, este registor queda grabado
     * en un documento de texto llamado "credito.txt".
     *
     * @param fecha String que se usa para la fecha
     * @param nit String que se usa para el nit
     * @param monto String que se usa para el monto
     */
    public void debito(String fecha,String nit,String monto){
        String linea;
        try {
            BufferedWriter efectivoA  = new BufferedWriter(new FileWriter("credito.txt",true));

            linea = fecha + "|" + nit + "|" + String.valueOf(monto)+"|0";
            efectivoA.write(linea);
            efectivoA.newLine();
            efectivoA.flush();
            efectivoA.close();
        } catch (IOException ex) {
            // nop
        }

    }


}
