package cajero;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Cliente {

    public String nit;
    public String nombre;
    public int cheque;
    public int credito;

    public int limpiar(){
        this.nit     = "";
        this.nombre  = "";
        this.cheque  = 0;
        this.credito = 0;
        return 0;
    }

    public int buscar(String nit) throws Exception{
        String[] registro = new String[4];
        String linea;
        BufferedReader clientesA;
        int encontrado = 0;

        try{
            clientesA = new BufferedReader(new FileReader("clientes.txt"));
            while ( (linea = clientesA.readLine() ) != null) {
                registro = linea.split("\\|");
                if(nit.compareTo(registro[0]) == 0){
                    encontrado = 1;
                    this.nit     = registro[0];
                    this.nombre  = registro[1];
                    this.cheque  = Integer.parseInt(registro[2]);
                    this.credito = Integer.parseInt(registro[3]);
                    break;
                }
            }
            clientesA.close();
        } catch (FileNotFoundException ex) {
            throw new Exception("Archivo no encontrado");
        } catch (IOException ex) {
            throw new Exception("Archivo no accesible");
        }
        return encontrado;
    }

    public int agregar(String nit,String nombre){
        String linea;
        try {
            BufferedWriter clientesA  = new BufferedWriter(new FileWriter("clientes.txt",true));
            linea = nit + "|" + nombre + "|0|0";
            clientesA.write(linea);
            clientesA.newLine();
            clientesA.flush();
            clientesA.close();
        } catch (IOException ex) {
            return 0;
        }
        return 1;
    }

}
