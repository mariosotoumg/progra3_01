/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mario
 */
class Pago {

    private SimpleDateFormat sdfecha = new SimpleDateFormat("yyyy-MM-dd");
    public String fecha  = sdfecha.format(new Date() );

    
     /**
     * Método efectivo, esto método se utiliza para ingresar el pago del 
     * cliente en caso que decida para en efectivo, se utilizara un 
     * String monto para el ingreso del efectivo que desee pagar, se 
     * implementa un BufferedWriter para escribir en el archivo “efectivo.txt” 
     * donde llevamos registro del monto a pagar, en este se ingresara 
     * los datos básicos como son  la fecha y el moto, por último
     * se declara una excepción por si no se logra encontrar el 
     * archivo o no se logra  ingresar.
     * 
     * @param monto String que se utiliza para el ingreso del monto
     */
    public void efectivo(String monto){
        String linea;
        try {
            BufferedWriter efectivoA  = new BufferedWriter(new FileWriter("efectivo.txt",true));

            linea = this.fecha + "|" + String.valueOf(monto);
            efectivoA.write(linea);
            efectivoA.newLine();
            efectivoA.flush();
            efectivoA.close();
        } catch (IOException ex) {
            // nop
        }
    }

      /**
     * Método cheque, este método se utiliza al momento de 
     * que el cliente desee pagar con un cheque, se utilizara 
     * un String denominado monto para ingresar la cantidad 
     * a pagar, el ingreso se realizara con un BufferedWriter 
     * para escribir en el registro de pago en un archivo de 
     * texto llamado “cheque.txt”, los datos ingresados serán 
     * la fecha y hora en el momento del ingreso y el monto
     * que se está realizando.
     * 
     * @param monto String que se utiliza para el ingreso del monto
     */
    public void cheque(String monto){
        String linea;
        try {
            BufferedWriter efectivoA  = new BufferedWriter(new FileWriter("cheque.txt",true));

            linea = this.fecha + "|" + String.valueOf(monto);
            efectivoA.write(linea);
            efectivoA.newLine();
            efectivoA.flush();
            efectivoA.close();
        } catch (IOException ex) {
            // nop
        }
    }

    /**
     * Método tarjeta, en este método registra todos los pagos realizados con tarjeta,
     * guarda la fecha de la operacion y el moto en un documento de texto llamado "tarjeta.txt".
     * 
     * @param monto String que se usa para la fecha
     */
    public void tarjeta(String monto){
        String linea;
        try {
            BufferedWriter efectivoA  = new BufferedWriter(new FileWriter("tarjeta.txt",true));

            linea = this.fecha + "|" + String.valueOf(monto);
            efectivoA.write(linea);
            efectivoA.newLine();
            efectivoA.flush();
            efectivoA.close();
        } catch (IOException ex) {
            // nop
        }
    }


}
