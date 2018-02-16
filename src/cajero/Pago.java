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
