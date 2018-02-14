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
 * Método Cliente, en este método se declara 
 * todas las variables a utilizar en la clase Cliente.
 * 
 * @author Gerson
 */
public class Cliente {

    public String nit;
    public String nombre;
    public int cheque;
    public int credito;
    
    /**
     * Método Limpiar, en este método se inicializan
     * las variables con el valor cero, o con “” para 
     * vaciarlas, este método permite borrar datos basura, 
     * los cuales se quedan al utilizar las variables, 
     * este método permite que no se encuentre errores 
     * por esos datos al ingresar uno nuevo. 
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
     * Método Buscar, este método permite buscar un registro de una 
     * persona, el dato que se pide para la busque es el nit, este
     * metodo implementa un BufferedReader para leer el archivo de 
     * texto, si el método logra encontrar su busque se retornara 
     * como encontrado y mostrara los datos, en caso contrario se 
     * presentaran dos Excepciones, las cuales dicen lo siguiente 
     * “Archivo no encontrado” o “Archivo no accesible” las cuales 
     * se activaran al momento de no encontrar el archivo de texto 
     * de clientes “clientes.txt”.
     * 
     * @param nit, String identificador de cliente a buscar 
     * @return, retorna un valor para poder saber que la búsqueda ha sido exitosa 
     * @throws, Exception muestra un excepción si no se encuentra el archivo cliente.txt
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
     * Método Agregar, en este método se utiliza un BufferedWriter 
     * para escribir en un archivo de texto llamado “clientes.txt” 
     * el cual lleva el registro de clientes que se ingresaran, si
     * el ingreso es exitoso se retornar “1” pero por si alguna 
     * razón el retorno no lo es se regresar un excepción que retornara 0.
     * 
     * @param nit, String que se utiliza para poner un número de identificación al cliente y que es único 
     * @param nombre, String que se utiliza para ingresar el nombre del cliente que se agregara 
     * @return, retorna un valor para saber si se ha agregado exitosamente o no 
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
