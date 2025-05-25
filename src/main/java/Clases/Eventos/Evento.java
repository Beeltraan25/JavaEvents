package Clases.Eventos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Evento implements Serializable {
    private String titulo;
    private String tipo;
    private Direccion direccion;
    private String fecha;
    private String hora;
    private String precio;
    private String portada;
    private double calificacion;
    


    //Constructor
    public Evento() {
        
    }


    public Evento(String titulo, String tipo, Direccion direccion, String fecha,String hora, String precio, String portada, double calificacion) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
        this.portada = portada;
        this.calificacion = 0.0;
        


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
    public String getFecha() {
        return fecha;
    }
    public String getHora() {
        return hora;
    }
    public String getPrecio() {
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
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public void setPortada(String portada) {
        this.portada = portada;
    }
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }


    //toString

    
    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", direccion=" + direccion +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", precio=" + precio +
                ", portada='" + portada + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}   
