/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
     * Guarda el pago del cliente en efectivo en el archivo correspondiente. La fecha es automática
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

    public int getEfectivo(String fecha) throws Exception{
        String[] registro = new String[2];
        String linea;
        BufferedReader efectivoA;
        int pagado = 0;
        try{
            efectivoA = new BufferedReader(new FileReader("efectivo.txt"));
            while ( (linea = efectivoA.readLine() ) != null) {
                registro = linea.split("\\|");
                if(fecha.compareTo(registro[0]) == 0){
                    pagado  += Integer.parseInt(registro[1]);
                }
            }
            efectivoA.close();
        } catch (FileNotFoundException ex) {
            throw new Exception("Archivo no encontrado");
        } catch (IOException ex) {
            throw new Exception("Archivo no accesible");
        }
        return pagado;
    }

    /**
     * Guarda el pago del cliente en cheque en el archivo correspondiente. La fecha es automática
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

    public int[] getCheque(String fecha) throws Exception{
        String[] registro = new String[2];
        int[] retorno = new int[2];
        String linea;
        BufferedReader chequeA;
        int pagado = 0;
        int docs   = 0;
        try{
            chequeA = new BufferedReader(new FileReader("cheque.txt"));
            while ( (linea = chequeA.readLine() ) != null) {
                registro = linea.split("\\|");
                if(fecha.compareTo(registro[0]) == 0){
                    docs++;
                    pagado  += Integer.parseInt(registro[1]);
                }
            }
            chequeA.close();
        } catch (FileNotFoundException ex) {
            throw new Exception("Archivo no encontrado");
        } catch (IOException ex) {
            throw new Exception("Archivo no accesible");
        }
        retorno[0] = docs;
        retorno[1] = pagado;
        return retorno;
    }

    /**
     * Guarda el pago del cliente por tarjeta en el archivo correspondiente. La fecha es automática
     *
     * @param monto String que se usa para la fecha
     */
    public void tarjeta(String monto){
        String linea;
        try {
            BufferedWriter tarjetaA  = new BufferedWriter(new FileWriter("tarjeta.txt",true));

            linea = this.fecha + "|" + String.valueOf(monto);
            tarjetaA.write(linea);
            tarjetaA.newLine();
            tarjetaA.flush();
            tarjetaA.close();
        } catch (IOException ex) {
            // nop
        }
    }

    public int getTarjeta(String fecha) throws Exception{
        String[] registro = new String[2];
        String linea;
        BufferedReader tarjetaA;
        int pagado = 0;
        try{
            tarjetaA = new BufferedReader(new FileReader("tarjeta.txt"));
            while ( (linea = tarjetaA.readLine() ) != null) {
                registro = linea.split("\\|");
                if(fecha.compareTo(registro[0]) == 0){
                    pagado  += Integer.parseInt(registro[1]);
                }
            }
            tarjetaA.close();
        } catch (FileNotFoundException ex) {
            throw new Exception("Archivo no encontrado");
        } catch (IOException ex) {
            throw new Exception("Archivo no accesible");
        }
        return pagado;
    }

}
