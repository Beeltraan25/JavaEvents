
package Clases.Eventos;

import Clases.Usuario.Cliente;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Clase que representa una reserva realizada por un cliente para un evento.
 */
public class Reserva {

    private LocalDateTime fechaReserva;
    private Evento evento;
    private Cliente cliente;
    private int cantidadEntradas;
    private double preciototal;

    /**
     * Constructor para crear una nueva reserva.
     *
     * @param fechaReserva     Fecha en la que se realiza la reserva.
     * @param evento           El evento reservado.
     * @param cliente          El cliente que realiza la reserva.
     * @param cantidadEntradas Número de entradas reservadas.
     */
    public Reserva(LocalDateTime fechaReserva, Evento evento, Cliente cliente, int cantidadEntradas) {
        this.fechaReserva = fechaReserva;
        this.evento = evento;
        this.cliente = cliente;
        this.cantidadEntradas = cantidadEntradas;
        this.preciototal = calcularPrecioTotal();
    }

 
    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }


    public Evento getEvento() {
        return evento;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public int getCantidadEntradas() {
        return cantidadEntradas;
    }


    public double getPrecioTotal() {
        return preciototal;
    }

    private double calcularPrecioTotal() {
        double precioBase = evento.getPrecio() * cantidadEntradas;
        if (cliente.getesvip()) {
            return precioBase * 0.9; // Descuento del 10% para clientes VIP
        }
        return precioBase;
    }

 
    public void generarFactura(String rutaArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("========== Factura de Reserva ==========\n");
            writer.write("Fecha de Reserva: " + fechaReserva.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("Cliente: " + cliente.getNombre() + " (" + cliente.getCorreo() + ")\n");
            writer.write("Evento: " + evento.getTitulo() + "\n");
            writer.write("Fecha del Evento: " + evento.getFechas().get(0).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
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