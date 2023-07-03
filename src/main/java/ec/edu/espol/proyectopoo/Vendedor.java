/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.util.ArrayList;

/**
 *
 * @author byron
 */
public class Vendedor extends Negociante {
    //atributos
    ArrayList<Vehiculo> vehiculos;
    
    //constructor
    public Vendedor(ArrayList<Vehiculo> vehiculos, String nombre, String apellido, String organizacion, String correo, String clave){    
        super(nombre, apellido, organizacion, correo, clave);
        this.vehiculos = vehiculos;
    }
    public ArrayList<Vehiculo> getVehiculos() {    
        return vehiculos;
    }

    //getter y setter
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {    
        this.vehiculos = vehiculos;
    }

    //metodos
    public void registroVendedor(String n, String ape, String orga, String correo, String clave) {
    }
    public void registroVendedor(String correo, String clave){
        
    }
    public void aceptarOferta(String correo, String clave){
    }
    public void revisarOfertas(String placa){
    }
    public void regresar(){
    }
}
