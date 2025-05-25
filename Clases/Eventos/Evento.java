package Clases.Eventos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Evento implements Serializable {
    private String titulo;
    private String tipo;
    private Direccion direccion;
    private ArrayList<LocalDateTime> fechas;
    private double precio;
    private String portada;
    private double calificacion;
    private ArrayList<Evento> eventos;


    //Constructor


    public Evento(String titulo, String tipo, Direccion direccion, double precio, String portada, double calificacion) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.fechas = new ArrayList<>();
        this.precio = precio;
        this.portada = portada;
        this.calificacion = 0.0;
        this.eventos = new ArrayList<>();


    //Getters and Setters


    }
    public String getTitulo() {
        return titulo;
    }
    public String getTipo() {
        return tipo;
    }
    public Direccion getDireccion() {
        return direccion;
    }
    public ArrayList<LocalDateTime> getFechas() {
        return fechas;
    }
    public double getPrecio() {
        return precio;
    }
    public String getPortada() {
        return portada;
    }
    public double getCalificacion() {
        return calificacion;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public void setFechas(ArrayList<LocalDateTime> fechas) {
        this.fechas = fechas;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setPortada(String portada) {
        this.portada = portada;
    }
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }
    public void eliminarEvento(Evento evento) {
        eventos.remove(evento);
    }

    //toString

    
    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", direccion=" + direccion +
                ", fechas=" + fechas +
                ", precio=" + precio +
                ", portada='" + portada + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}   
