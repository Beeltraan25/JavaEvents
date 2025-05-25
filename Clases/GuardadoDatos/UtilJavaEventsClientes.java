/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.GuardadoDatos;

import Clases.Usuario.Cliente;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class UtilJavaEventsClientes {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    
    
    
    
    /** Carga los datos de Productos del fichero */
    public static void cargarDatos() {
        try {
            try (FileInputStream istreamclie = new FileInputStream("src/main/resources/datosUsuarios/clientes.dat")) {
                ObjectInputStream oisclie = new ObjectInputStream(istreamclie);
                clientes = (ArrayList) oisclie.readObject();
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } 
    }//fin cargarDatos

    /** Guarda los datos de Productos en el fichero */
    public static void guardarDatos() {
        try {
            //Si hay datos los guardamos...
            if (!clientes.isEmpty()) {
                try (FileOutputStream ostreamclie = new FileOutputStream("src/main/resources/datosUsuarios/clientes.dat")) {
                    ObjectOutputStream oosclie = new ObjectOutputStream(ostreamclie);
                    //guardamos el array de Productos
                    oosclie.writeObject(clientes);
                }
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } 
    }//fin guardarDatos
}
