package Clases.Usuario;

import Clases.Eventos.Direccion;
import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private String correo;
    private String clave;
    private String telefono;
    private Direccion direccion;
    private TarjetaDeCredito tarjetaDeCredito;
    private boolean vip;


    //Constructor
    
    public Cliente() {
    }

    public Cliente(String nombre, String correo, String clave, String telefono, Direccion direccion, TarjetaDeCredito tarjetaDeCredito, boolean vip) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tarjetaDeCredito = tarjetaDeCredito;
        this.vip = vip;
    }

    //Getters and Setters


    public String getNombre() {
        return nombre;
    }  
    public String getCorreo() {
        return correo;
    }
    public String getClave() {
        return clave;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getTelefono() {
        return telefono;
    }
    public Direccion getDireccion() {
        return direccion;
    }
    public TarjetaDeCredito getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }
    public boolean getvip() {
        return vip;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }
    public void setvip(boolean vip) {
        this.vip = vip;
    }

    //toString

    @Override
    public String toString() {
        return "Cliente{" + 
                        "nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + ", telefono=" + telefono + ", direccion=" + direccion + ", tarjetaDeCredito=" + tarjetaDeCredito + ", esvip=" + vip + '}';
    }

    

    }

