
package Clases.Gestor;
import Clases.Eventos.Reserva;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GestorReservas {

    private List<Reserva> reservas;

    public GestorReservas() {
        this.reservas = new ArrayList<>();
    }

    public void registrarReserva(Reserva reserva) {
        reservas.add(reserva);
    }


    public List<Reserva> obtenerReservas() {
        return new ArrayList<>(reservas);
    }


    //public List<Reserva> buscarReservasDesdeFecha(LocalDateTime fecha) {
        //return reservas.stream()
                //.filter(reserva -> reserva.getFechaReserva().isAfter(fecha))
                //.collect(Collectors.toList());
    //}


    public boolean eliminarReserva(Reserva reserva) {
        return reservas.remove(reserva);
    }
}
