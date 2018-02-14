package cajero;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * El método Cliente, este método es utilizado para la inicialización de las variables a utilizar en la clase Cliente 
 * 
 * @author Gerson
 */

public class Cliente {

    public String nit;
    public String nombre;
    public int cheque;
    public int credito;
    
  /**
   *El método Limpiar, este método es encargado de limpiar las variables utilizadas anteriormente para que así desechar datos basura que no utilizaremos y  que podrían afectar a datos resientes que deseemos ingresar     
   *
   * @return 
   */  

    public int limpiar(){
        this.nit     = "";
        this.nombre  = "";
        this.cheque  = 0;
        this.credito = 0;
        return 0;
    }
/**
 * El meto buscar, la funcionalidad de este método es la de ingresar un cierto parámetro ingresándolo por la variable denominada nit, este los compara en un archivo de texto, y si se ha logrado encontrado este mostrara los datos del cliente, pero si la búsqueda no es  exitosa muestra un mensaje que en el cual dice que no se ha encontrado los datos del Cliente  
 * 
 * @param nit
 * @return
 * @throws Exception 
 */
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
    /**
     * El método agregar, la funcionalidad de este es la de agregar un nuevo registro en este caso al archivo de texto, en esta función se deben ingresar los datos básicos que son el nit y nombre del cliente a ingresar.
     * 
     * @param nit
     * @param nombre
     * @return 
     */
    public int agregar(String nit,String nombre){
        String linea;
        try {
            BufferedWriter clientesA  = new BufferedWriter(new FileWriter("clientes.txt",true));
            linea = nit + "|" + nombre + "|0|0|";
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
