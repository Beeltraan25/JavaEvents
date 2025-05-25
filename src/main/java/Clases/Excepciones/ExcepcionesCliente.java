/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Excepciones;

/**
 *
 * @author Sergio
 */
public class ExcepcionesCliente extends Exception {
    
    //Excepcion constante que manda un mensaje de texto si el nombre es incorrecto
    
    public static final String NOMBRE_ERRONEO = "El nombre que has introducido es incorrecto";
    
    //Excepcion constante que manda un mensaje de texto si el correo es incorrecto
    
    public static final String CORREO_ERRONEO = "El correo que has introducido es incorrecto";
    
    //Excepcion constante que manda un mensaje de texto si la clave es incorrecta
    
    public static final String CLAVE_ERRONEO = "La clave que has introducido es incorrecta";
    
    //Excepcion constante que manda un mensaje de texto si el telefono es incorrecto
    
    public static final String TELEFONO_ERRONEO = "El telefono que has introducido es incorrrecto";
    
    //Excepcion constante que manda un mensaje de texto si algun dato de la direccion es incorrecto
    
    public static final String DIRECCION_ERRONEA = "La direccion que has introducido es incorrecta";
    
    //Excepcion constante que manda un mensaje de texto si algun dato de la tarjeta es incorrecto
    
    public static final String TARJETADECREDITO_ERRONEA = "La tarjeta de credito que has introducido es incorrecta";
    
    //Excepcion constante que manda un mensaje de texto si el usuario ya está registrado
    
    public static final String USUARIO_LOGEADO = "Este usuario ya esta registrado en la aplicacion";
    
    
    //Excepcion que manda si se produce cualquier otro error que no sean los anteriores 
    
    public ExcepcionesCliente() {
        super("Se ha producido un error a la hora de registrarte");
    }
    public ExcepcionesCliente(String mensaje) {
        super(mensaje);
    }
    
}
