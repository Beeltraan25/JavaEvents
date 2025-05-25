/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.GuardadoDatos;

import Clases.Eventos.Evento;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sergio
 */
public class UtilJavaEventsEventos {
    public static ArrayList<Evento> eventos = new ArrayList<>();
    private static Evento even;

        
    
    //Se encarga de iniciar la ArrayList de Eventos
    public static void setEventos(ArrayList<Evento> e) {
        eventos = e;
    }
    
    
    /** Carga los datos de Eventos del fichero */
    
    
    public static void cargarDatosEventos() {
        try {
            try (FileInputStream istreameven = new FileInputStream("eventos.dat")) {
                ObjectInputStream oiseven = new ObjectInputStream(istreameven);
                eventos = (ArrayList) oiseven.readObject();
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        }
        
    }

    //fin cargarDatos

    
    /** Guarda los datos de Eventos en el fichero */
    
    
    public static void guardarDatosEventos() {
        try {
            //Si hay datos los guardamos...
            if (!eventos.isEmpty()) {
                try (FileOutputStream ostreameven = new FileOutputStream("eventos.dat")) {
                    ObjectOutputStream ooseven = new ObjectOutputStream(ostreameven);
                    //guardamos el array de Eventos
                    ooseven.writeObject(eventos);
                }
                System.out.println("Datos guardados correctamente.");
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } 
    }

    //fin guardarDatos
    
    
        public static boolean AltaEvento(Evento even ) {
        if (ConsultaEventosPorTitulo(even.getTitulo()) == null) {
            eventos.add(even);
            return true;
        } else {
            return false;
        }

    }

    /** Da de baja una Producto
     * @param even
     * @return  */
    public static boolean BajaEvento(Evento even) {
        if (eventos.contains(even)) {
            eventos.remove(even);
            return true;
        } else {
            return false;
        }
    }
        public static Evento consultaCliente(int indice) {
        even = eventos.get(indice);
        return even;
        
        }
        
        
       public static Evento ConsultaEventosPorTitulo(String titulo) { //Comparador para ordenar los Clientes por su correo
        Comparator TituloevenComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Evento e1 = (Evento) o1;
                Evento e2 = (Evento) o2;
                return e1.getTitulo().compareTo(e2.getTitulo());
            }
        };
        //Ordenamos el array
        Collections.sort(eventos, TituloevenComp);
        return even;
    }
       
       
       
      public static ArrayList<Evento> getEventosPorTitulo() {
        //Comparador para ordenar los Productos por su nombre
        Comparator TitevenComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Evento e1 = (Evento) o1;
                Evento e2 = (Evento) o2;
                return e1.getTitulo().compareTo(e2.getTitulo());
            }
        };
        Collections.sort(eventos, TitevenComp);
        return eventos;
      }
      
      public static ArrayList<Evento> getEventosPorTipo() {
        //Comparador para ordenar los Productos por su nombre
        Comparator TipevenComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Evento e1 = (Evento) o1;
                Evento e2 = (Evento) o2;
                return e1.getTipo().compareTo(e2.getTipo());
            }
        };
        //Ordenamos el array
        Collections.sort(eventos, TipevenComp);
        return eventos;
    }
              public static ArrayList<Evento> getEventosPorCalle() {
        //Comparador para ordenar los Productos por su nombre
        Comparator CalevenComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Evento e1 = (Evento) o1;
                Evento e2 = (Evento) o2;
                return e1.getDireccion().getCalle().compareTo(e2.getDireccion().getCalle());
            }
        };
        //Ordenamos el array
        Collections.sort(eventos, CalevenComp);
        return eventos;
    }
              
       public static ArrayList<Evento> getEventosPorNumero() {
    Comparator NumevenComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Evento e1 = (Evento) o1;
            Evento e2 = (Evento) o2;
            return e1.getDireccion().getNumero().compareTo(e2.getDireccion().getNumero());
        }
    };
    Collections.sort(eventos, NumevenComp);
    return eventos;
    
    }
            
     public static ArrayList<Evento> getEventosPorCiudad() {
    Comparator CiudadevenComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Evento e1 = (Evento) o1;
            Evento e2 = (Evento) o2;
            return e1.getDireccion().getCiudad().compareTo(e2.getDireccion().getCiudad());
        }
    };
    Collections.sort(eventos, CiudadevenComp);
    return eventos;
    
    }   
     public static ArrayList<Evento> getEventosPorCodigoPostal() {
    Comparator CodigoPostalevenComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Evento e1 = (Evento) o1;
            Evento e2 = (Evento) o2;
            return e1.getDireccion().getCodigopostal().compareTo(e2.getDireccion().getCodigopostal());
        }
    };
    Collections.sort(eventos, CodigoPostalevenComp);
    return eventos;
    
    }   
    
    
    public static ArrayList<Evento> getEventosPorFecha() {
    Comparator FechaevenComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Evento e1 = (Evento) o1;
            Evento e2 = (Evento) o2;
            return e1.getFecha().compareTo(e2.getFecha());
        }
    };
    Collections.sort(eventos, FechaevenComp);
    return eventos;
    
    }   public static ArrayList<Evento> getEventosPorHora() {
    Comparator HoraevenComp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Evento e1 = (Evento) o1;
            Evento e2 = (Evento) o2;
            return e1.getHora().compareTo(e2.getHora());
        }
    };
    Collections.sort(eventos, HoraevenComp);
    return eventos;
    }
    
        public static ArrayList<Evento> getEventosPorPrecio() {
        //Comparador para ordenar los Eventos por su Precio
        Comparator PrecioevenComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Evento e1 = (Evento) o1;
                Evento e2 = (Evento) o2;
                return e1.getPrecio().compareTo(e2.getPrecio());
            }
        };
        //Ordenamos el array
        Collections.sort(eventos, PrecioevenComp);
        return eventos;
    }
         public static ArrayList<Evento> getEventosPorCalificacion() {
        //Comparador para ordenar los Eventos por su Precio
        Comparator CalifevenComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Evento e1 = (Evento) o1;
                Evento e2 = (Evento) o2;
                Double ecal1 = e1.getCalificacion();
                Double ecal2 = e2.getCalificacion();
                return ecal1.compareTo(ecal2);
            }
        };
        //Ordenamos el array
        Collections.sort(eventos, CalifevenComp);
        return eventos;
    }
        
           public static Evento consultaEventosPorTitulo(String titulo) {//Comparador para ordenar los Eventos por su evento
        Comparator TitevenComp = new Comparator() {


            @Override
            public int compare(Object o1, Object o2) {
                Evento e1 = (Evento) o1;
                Evento e2 = (Evento) o2;
                return e1.getTitulo().compareTo(e2.getTitulo());
            }
        };
        //Ordenamos el array
        Collections.sort(eventos, TitevenComp);
        //creamos un Producto con el código a buscar
        Evento c = new Evento();
        c.setTitulo(titulo);
        int pos = Collections.binarySearch(eventos, c, TitevenComp);
        if (pos >= 0) {
            even = eventos.get(pos);
        } else {
            even = null;
        }

        return even;
    }
           public static boolean modificaEvento(Evento even, String e_titulo, String e_tipo, String e_calle, String e_numero, String e_codigopostal, String e_ciudad, String e_fecha, String e_precio, String e_hora, String e_imagen) {
        if (even == null || !eventos.contains(even)) {
            return false;
        }
        even.setTitulo(e_titulo);
        even.setTipo(e_tipo);
        even.getDireccion().setCalle(e_calle);
        even.getDireccion().setNumero(e_numero);
        even.getDireccion().setCodigopostal(e_codigopostal);
        even.getDireccion().setCiudad(e_ciudad);
        even.setFecha(e_fecha);
        even.setPrecio(e_precio);
        even.setHora(e_hora);
        even.setPortada(e_imagen);
        
        return true;
    }
}
