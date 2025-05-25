/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.GuardadoDatos;

import Clases.Eventos.Reserva;
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
public class UtilJavaEventsReservas {
    public static ArrayList<Reserva> reservas = new ArrayList<>();
    private static Reserva reser;
    
    
    
    public static void setReservas(ArrayList<Reserva> r) {
        reservas = r;
    }
    /** Carga los datos de Productos del fichero */
    public static void cargarDatosReservas() {
        try {
            try (FileInputStream istreamreser = new FileInputStream("reservas.dat")) {
                ObjectInputStream oisreser = new ObjectInputStream(istreamreser);
                reservas = (ArrayList) oisreser.readObject();
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } 
    }//fin cargarDatos

    /** Guarda los datos de Productos en el fichero */
    public static void guardarDatosReservas() {
        try {
            //Si hay datos los guardamos...
            if (!reservas.isEmpty()) {
                try (FileOutputStream ostreamreser = new FileOutputStream("reservas.dat")) {
                    ObjectOutputStream oosreser = new ObjectOutputStream(ostreamreser);
                    //guardamos el array de Productos
                    oosreser.writeObject(reservas);
                }
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } 
    }//fin guardarDatos
    
        public static boolean AltaReserva(Reserva reser ) {
            reservas.add(reser);
            return true;

    }

    /** Da de baja una Reserva
     * @param reser
     * @return  */
    public static boolean BajaReserva(Reserva reser) {
        reservas.remove(reser);
        return true;
    }
        public static Reserva consultaReserva(int indice) {
        reser = reservas.get(indice);
        return reser;
        
        }
       public static Reserva ConsultaReservasPorFecha(String fechaReserva) { //Comparador para ordenar los Clientes por su correo
        Comparator fechreserComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Reserva r1 = (Reserva) o1;
                Reserva r2 = (Reserva) o2;
                return r1.getFechaReserva().compareTo(r2.getFechaReserva());
            }
        };
        //Ordenamos el array
        Collections.sort(reservas, fechreserComp);
        return reser;
    }
      public static ArrayList<Reserva> getReservasPorFecha() {
        //Comparador para ordenar los Productos por su nombre
        Comparator fechreserComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Reserva r1 = (Reserva) o1;
                Reserva r2 = (Reserva) o2;
                return r1.getFechaReserva().compareTo(r2.getFechaReserva());
            }
        };
        //Ordenamos el array
        Collections.sort(reservas, fechreserComp);
        return reservas;
    }
            public static ArrayList<Reserva> getReservasPorEventoTitulo() {
        //Comparador para ordenar los Productos por su nombre
        Comparator EveTitreserComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Reserva r1 = (Reserva) o1;
                Reserva r2 = (Reserva) o2;
                return r1.getEvento().getTitulo().compareTo(r2.getEvento().getTitulo());
            }
        };
        //Ordenamos el array
        Collections.sort(reservas, EveTitreserComp);
        return reservas;
    }
        public static ArrayList<Reserva> getReservasPorClienteCor() {
        //Comparador para ordenar los Productos por su nombre
        Comparator CliCorreserComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Reserva r1 = (Reserva) o1;
                Reserva r2 = (Reserva) o2;
                return r1.getCliente().getCorreo().compareTo(r2.getCliente().getCorreo());
            }
        };
        //Ordenamos el array
        Collections.sort(reservas, CliCorreserComp);
        return reservas;
    }
        public static ArrayList<Reserva> getReservasPorCantidadEntradas() {
        //Comparador para ordenar los Productos por su nombre
        Comparator EntreserComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Reserva r1 = (Reserva) o1;
                Reserva r2 = (Reserva) o2;
                return r1.getCantidadEntradas().compareTo(r2.getCantidadEntradas());
            }
        };
        //Ordenamos el array
        Collections.sort(reservas, EntreserComp);
        return reservas;
    }
        
        public static ArrayList<Reserva> getReservasPrecioTotal() {
        //Comparador para ordenar los Productos por su nombre
        Comparator PrereserComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Reserva r1 = (Reserva) o1;
                Reserva r2 = (Reserva) o2;
                return r1.getPrecioTotal().compareTo(r2.getPrecioTotal());
            }
        };
        //Ordenamos el array
        Collections.sort(reservas, PrereserComp);
        return reservas;
    }
        public static Reserva consultaReserPorFecha(String fechaReserva) {//Comparador para ordenar los Clientes por su correo
        Comparator fechreserComp = new Comparator() {


            @Override
            public int compare(Object o1, Object o2) {
                Reserva r1 = (Reserva) o1;
                Reserva r2 = (Reserva) o2;
                return r1.getFechaReserva().compareTo(r2.getFechaReserva());
            }
        };
        //Ordenamos el array
        Collections.sort(reservas, fechreserComp);
        //creamos un Producto con el código a buscar
        Reserva r = new Reserva();
        r.setFechaReserva(fechaReserva);
        int pos = Collections.binarySearch(reservas, r, fechreserComp);
        if (pos >= 0) {
            reser = reservas.get(pos);
        } else {
            reser = null;
        }

        return reser;
    }
}

