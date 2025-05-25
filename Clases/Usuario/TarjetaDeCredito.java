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


    //Metodo para validar el nombre de la tarjeta de crédito


    public static boolean validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("El nombre del titular no puede estar vacio, introduzca un nombre valido.");
            return false;
        }
        return true;
    }


    //Metodo para validar el número de la tarjeta de crédito


    public static boolean validarNumero(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            System.out.println("El número de la tarjeta no puede estar vacio, introduzca un número valido.");
            return false;
        }
        if (numero.length() != 16) {
                return false;
        }
        return true;
    }


    //Metodo para validar la fecha de caducidad de la tarjeta de crédito


    public static boolean validarFechaCaducidad(String fechaCaducidad) {
        if (fechaCaducidad == null || fechaCaducidad.trim().isEmpty()) {
            System.out.println("La fecha de caducidad no puede estar vacia, introduzca una fecha valida.");
            return false;
       }
       return true;
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
