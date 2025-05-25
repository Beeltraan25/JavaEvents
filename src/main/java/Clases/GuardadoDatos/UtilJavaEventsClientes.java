/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.GuardadoDatos;

import Clases.Eventos.Direccion;
import Clases.Usuario.Cliente;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Sergio
 */
public class UtilJavaEventsClientes {
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Cliente clie;
    
    
    
    public static void setClientes(ArrayList<Cliente> e) {
        clientes = e;
    }
    /** Carga los datos de Productos del fichero */
    public static void cargarDatosClientes() {
        try {
            try (FileInputStream istreamclie = new FileInputStream("clientes.dat")) {
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
    public static void guardarDatosClientes() {
        try {
            //Si hay datos los guardamos...
            if (!clientes.isEmpty()) {
                try (FileOutputStream ostreamclie = new FileOutputStream("clientes.dat")) {
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
    
        public static boolean AltaCliente(Cliente clie ) {
        if (ConsultaClientesPorCorreo(clie.getCorreo()) == null) {
            clientes.add(clie);
            return true;
        } else {
            return false;
        }

    }

    /** Da de baja una Producto
     * @param objpro
     * @return  */
    public static boolean BajaCliente(Cliente clie) {
        if (clientes.contains(clie)) {
            clientes.remove(clie);
            return true;
        } else {
            return false;
        }
    }
        public static Cliente consultaCliente(int indice) {
        clie = clientes.get(indice);
        return clie;
        
        }
       public static Cliente ConsultaClientesPorCorreo(String correo) { //Comparador para ordenar los Clientes por su correo
        Comparator CorreoCliComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Cliente c1 = (Cliente) o1;
                Cliente c2 = (Cliente) o2;
                return c1.getCorreo().compareTo(c2.getCorreo());
            }
        };
        //Ordenamos el array
        Collections.sort(clientes, CorreoCliComp);
        return clie;
    }
      public static ArrayList<Cliente> getClientesPorNombre() {
        //Comparador para ordenar los Productos por su nombre
        Comparator NomcliComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Cliente c1 = (Cliente) o1;
                Cliente c2 = (Cliente) o2;
                return c1.getNombre().compareTo(c2.getNombre());
            }
        };
        //Ordenamos el array
        Collections.sort(clientes, NomcliComp);
        return clientes;
    }
          public static ArrayList<Cliente> getClientesPorCorreo() {
        //Comparador para ordenar los Productos por su nombre
        Comparator CorcliComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Cliente c1 = (Cliente) o1;
                Cliente c2 = (Cliente) o2;
                return c1.getCorreo().compareTo(c2.getCorreo());
            }
        };
        //Ordenamos el array
        Collections.sort(clientes, CorcliComp);
        return clientes;
    }
              public static ArrayList<Cliente> getClientesPorClave() {
        //Comparador para ordenar los Productos por su nombre
        Comparator ClacliComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Cliente c1 = (Cliente) o1;
                Cliente c2 = (Cliente) o2;
                return c1.getClave().compareTo(c2.getClave());
            }
        };
        //Ordenamos el array
        Collections.sort(clientes, ClacliComp);
        return clientes;
    }
              
            public static ArrayList<Cliente> getClientesPorTelefono() {
    // Comparador para ordenar los Clientes por su teléfono
    Comparator TelCliComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Cliente c1 = (Cliente) o1;
            Cliente c2 = (Cliente) o2;
            return c1.getTelefono().compareTo(c2.getTelefono());
        }
    };
    // Ordenamos el array
    Collections.sort(clientes, TelCliComp);
    return clientes;
    }
            
            public static ArrayList<Cliente> getClientesPorCalle() {
    Comparator CalleCliComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Cliente c1 = (Cliente) o1;
            Cliente c2 = (Cliente) o2;
            return c1.getDireccion().getCalle().compareTo(c2.getDireccion().getCalle());
        }
    };
    Collections.sort(clientes, CalleCliComp);
    return clientes;
    
    }   public static ArrayList<Cliente> getClientesPorNumero() {
    Comparator NumCliComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Cliente c1 = (Cliente) o1;
            Cliente c2 = (Cliente) o2;
            return c1.getDireccion().getNumero().compareTo(c2.getDireccion().getNumero());
        }
    };
    Collections.sort(clientes, NumCliComp);
    return clientes;
    
    }   public static ArrayList<Cliente> getClientesPorCiudad() {
    Comparator CiudadCliComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Cliente c1 = (Cliente) o1;
            Cliente c2 = (Cliente) o2;
            return c1.getDireccion().getCiudad().compareTo(c2.getDireccion().getCiudad());
        }
    };
    Collections.sort(clientes, CiudadCliComp);
    return clientes;
    
    }   public static ArrayList<Cliente> getClientesPorCodigoPostal() {
    Comparator CodigoPostalCliComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Cliente c1 = (Cliente) o1;
            Cliente c2 = (Cliente) o2;
            return c1.getDireccion().getCodigopostal().compareTo(c2.getDireccion().getCodigopostal());
        }
    };
    Collections.sort(clientes, CodigoPostalCliComp);
    return clientes;
    
    }   public static ArrayList<Cliente> getClientesPorVip() {
    Comparator VipCliComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Cliente c1 = (Cliente) o1;
            Cliente c2 = (Cliente) o2;
            return Boolean.compare(c1.getvip(), c2.getvip()); // Ordenando primero los VIP
        }
    };
    Collections.sort(clientes, VipCliComp);
    return clientes;
    } 
    
    
            
            
              
    
    
    public static Cliente consultaClientePorCorreo(String correo) {//Comparador para ordenar los Clientes por su correo
        Comparator CorreocliComp = new Comparator() {


            @Override
            public int compare(Object o1, Object o2) {
                Cliente c1 = (Cliente) o1;
                Cliente c2 = (Cliente) o2;
                return c1.getCorreo().compareTo(c2.getCorreo());
            }
        };
        //Ordenamos el array
        Collections.sort(clientes, CorreocliComp);
        //creamos un Producto con el código a buscar
        Cliente c = new Cliente();
        c.setCorreo(correo);
        int pos = Collections.binarySearch(clientes, c, CorreocliComp);
        if (pos >= 0) {
            clie = clientes.get(pos);
        } else {
            clie = null;
        }

        return clie;
    }
    
    
    //Verifica si el correo tiene un formato valido, 
    //La primera parte es la que guia la zona de las letras, los numeros, los puntos, guiones, etc.
    //La segunda parte obliga a que el correo tenga si o si una arroba si este no la tiene no dejara registrarse al usuario.
    //La tercera parte es la que se encarga de la parte penultima de un correo, por asi decirlo que tiene que llevar el @gmail, @hotmail , @yahoo, etc.
    //La cuarta parte es la que se encarga de medir la parte final, por asi decirlo que se aseguro de que lleve el .com, .es, etc.
    public static boolean esCorreoValido(String correo){ 
        return correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"); 
    }
    
    public static boolean esContrasenaValida(String contrasena) { 
        if (contrasena.length()<8) {  //Verifica si la contraseña tiene mas de 8 digitos, si no devuelve false
        return false;
        } 
        boolean mayus = false; //Crea 3 variables que se van a encargar de verificar si la contraseña tiene mayusculas,minusculas o numeros
        boolean minus = false; 
        boolean num = false; 
        for (int i = 0; i < contrasena.length(); i++) { //El bucle se encarga de analizar los caracteres uno a uno
            if (contrasena.charAt(i) >= 47 && contrasena.charAt(i) <= 58) { //Comparamos posiciones en codigo ASCII que en la tabla son los digitos del 0 al 9 
                num = true; 
            } else if (contrasena.charAt(i) >= 64 && contrasena.charAt(i) <= 91) { mayus = true; //Comparamos posiciones en codigo ASCII que en la tabla son los caracteres de la A-Z en Mayusculas
            } else if (contrasena.charAt(i) >= 97 && contrasena.charAt(i) <= 122) { minus = true; //Comparamos posiciones en codigo ASCII que en la tabla son los caracteres de la A-Z en Minusculas
            } 
        } return (num && mayus && minus); //La contraseña se valida si tiene mayusculas, minusculas y numeros
    }
}
