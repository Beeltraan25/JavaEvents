package Clases.Usuario;

//SIN TERMINAR EL METODO DE VALIDACION FECHA DE CADUCIDAD

import java.io.Serializable;



public class TarjetaDeCredito implements Serializable {
    private String nombre;
    private String numero;
    private String fechaCaducidad;

    public TarjetaDeCredito(String nombre, String numero, String fechaCaducidad) {
        this.nombre = nombre;
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
    }


    //Getters and Setters


    public String getNombre() {
        return nombre;
    }
    public String getNumero() {
        return numero;
    }
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    //toString

    
    @Override
    public String toString() {
        return "TarjetaDeCredito{" +
                "nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", fechaCaducidad='" + fechaCaducidad + '\'' +
                '}';
    }
}
