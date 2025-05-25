/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Excepciones;

/**
 *
 * @author Sergio
 */
public class ExcepcionesHuecosVacios extends Exception {
    public ExcepcionesHuecosVacios() {
        super("Por favor rellene todos los campos"); //Salta un mensaje de Alerta Pidiendo que rellene los huecos que están vacios
    }
}
