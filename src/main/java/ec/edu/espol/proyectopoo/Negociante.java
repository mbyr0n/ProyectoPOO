/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

/**
 *
 * @author byron
 */
public class Negociante {
    //atributos
    protected String nombre, apellido, organizacion, correo, clave;
    
    //constructor
    public Negociante(String nombre, String apellido, String organizacion, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.organizacion = organizacion;
        this.correo = correo;
        this.clave = clave;
    }
    
    //getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    //metodos
    public void almacenarContrasenia(String usuario, String contrasenia){
        
    }
    public void calcularHash(String contrasenia){
        
    }
    
    
}
