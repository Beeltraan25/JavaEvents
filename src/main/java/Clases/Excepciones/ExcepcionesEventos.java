/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Excepciones;

/**
 *
 * @author Sergio
 */
public class ExcepcionesEventos extends Exception {
    
    //Excepcion constante que manda un mensaje de texto si el titulo de un evento es incorrecto
    
    public static final String TITULO_INCORRECTO = "El titulo ingresado es incorrecto";
    
    //Excepcion constante que manda un mensaje de texto si el precio introducido del evento es incorrecto
    
    public static final String PRECIO_INCORRECTO = "El precio ingresado del evento es incorrecto";
    
    //Excepcion constante que manda un mensaje de texto si la fecha introducida del evento es incorrecta
    
    public static final String FECHAS_INCORRECTO = "La fecha ingresada del evento es incorrecta";
    
    //Excepcion constante que manda un mensaje de texto si la hora introducida del evento es incorrecta
    
    public static final String HORA_INCORRECTA = "La hora ingresada del evento es incorrecta";
    
    //Excepcion constante que manda un mensaje de texto si la calificacion del evento introducida es incorrecta
    
    public static final String CALIFICACION_INCORRECTA = "La calificacion ingresada del evento es incorrecta";
    
    //Excepcion constante que manda un mensaje de texto si la imagen del evento no es valida
    
    public static final String FOTOGRAFIA_INCORRECTA = "La fotografia ingresada no es valida";
    
    
    public ExcepcionesEventos () {
        super("Se ha producido un error a la hora de introducir los datos del evento");
    }
    
    public ExcepcionesEventos(String mensaje) {
        super(mensaje);
    }
    
    
}
