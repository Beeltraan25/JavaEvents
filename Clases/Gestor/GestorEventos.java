
package Clases.Gestor;

import Clases.Eventos.Evento;
import Clases.Eventos.TipoEvento;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorEventos {

    private List<Evento> eventos;

    public GestorEventos() {
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }
 
    public boolean modificarEvento(Evento evento) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getTitulo().equals(evento.getTitulo())) {
                eventos.set(i, evento);
                return true;
            }
        }
        return false;
    }


    public boolean eliminarEvento(String titulo) {
        return eventos.removeIf(evento -> evento.getTitulo().equals(titulo));
    }


    public List<Evento> buscarEventosPorTipo(String tipo) {
        return eventos.stream()
                .filter(evento -> evento.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    public List<Evento> buscarEventosPorCiudad(String ciudad) {
        return eventos.stream()
                .filter(evento -> evento.getDireccion().getCiudad().equalsIgnoreCase(ciudad))
                .collect(Collectors.toList());
    }

  
    public List<Evento> obtenerEventos() {
        return new ArrayList<>(eventos);
    }
}
