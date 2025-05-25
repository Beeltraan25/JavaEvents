package Clases.Eventos;

import java.io.Serializable;

public class Direccion implements Serializable {
    private String calle;
    private String numero;;
    private String ciudad;
    private String codigopostal;

    //Constructor

    
    public Direccion(String calle, String numero, String ciudad, String codigopostal) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.codigopostal = codigopostal;


    //Getters y Setters


    }
    public String getCalle() {
        return calle;
    }
    public String getNumero() {
        return numero;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getCodigopostal() {
        return codigopostal;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }


    //toString


    @Override
    public String toString() {
        return "Direccion{" +
                "  calle='" + calle + '\'' +
                ", numero=" + numero +
                ", ciudad='" + ciudad + '\'' +
                ", codigopostal='" + codigopostal + '\'' +
                '}';
    }
}
