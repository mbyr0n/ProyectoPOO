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
public class Comprador extends Negociante {
    //atributos
    private ArrayList<Oferta> ofertas;
    
    //constructor
    public Comprador(int id, String nombre, String apellido, String organizacion, String correo, String clave) {
        super(id, nombre, apellido, organizacion, correo, clave);
        this.ofertas = new ArrayList<>();
    }
    
    //metodos
    public void registroComprador(){
    }
    public void buscarVehiculo(char tipovehiculo, double rec, int anio, double precio){
    }
    public void ofertaVehiculo(double ofert){
    }
}
