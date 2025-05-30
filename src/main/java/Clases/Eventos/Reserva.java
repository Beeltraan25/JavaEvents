
package Clases.Eventos;

import Clases.Usuario.Cliente;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Clase que representa una reserva realizada por un cliente para un evento.
 */
public class Reserva implements Serializable {

    private String fechaReserva;
    private Evento evento;
    private Cliente cliente;
    private String cantidadEntradas;
    private String preciototal;

    /**
     * Constructor para crear una nueva reserva.
     *
     * @param fechaReserva     Fecha en la que se realiza la reserva.
     * @param evento           El evento reservado.
     * @param cliente          El cliente que realiza la reserva.
     * @param cantidadEntradas Número de entradas reservadas.
     */
    public Reserva() {
        
    }
    
    public Reserva(String fechaReserva, Evento evento, Cliente cliente, String cantidadEntradas, String preciototal) {
        this.fechaReserva = fechaReserva;
        this.evento = evento;
        this.cliente = cliente;
        this.cantidadEntradas = cantidadEntradas;
        this.preciototal = preciototal;
    }
    
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

 
    public String getFechaReserva() {
        return fechaReserva;
    }


    public Evento getEvento() {
        return evento;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public String getCantidadEntradas() {
        return cantidadEntradas;
    }


    public String getPrecioTotal() {
        return preciototal;
    }


 
    public void generarFactura(String rutaArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("========== Factura de Reserva ==========\n");
            //writer.write("Fecha de Reserva: " + fechaReserva.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("Cliente: " + cliente.getNombre() + " (" + cliente.getCorreo() + ")\n");
            writer.write("Evento: " + evento.getTitulo() + "\n");
            //writer.write("Fecha del Evento: " + evento.getFecha().get(0).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("Cantidad de Entradas: " + cantidadEntradas + "\n");
            writer.write("Precio Total: " + String.format("%.2f", preciototal) + " €\n");
            writer.write("========================================");
        }
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fechaReserva=" + fechaReserva +
                ", evento=" + evento.getTitulo() +
                ", cliente=" + cliente.getNombre() +
                ", cantidadEntradas=" + cantidadEntradas +
                ", precioTotal=" + String.format("%.2f", preciototal) +
                '}';
    }
}