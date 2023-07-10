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
public class Oferta {
    private Comprador ofertador;
    private Vehiculo vehiculo;
    private double oferta;

    public Oferta(Comprador comprador, Vehiculo vehiculo, double oferta) {
        this.ofertador = comprador;
        this.vehiculo = vehiculo;
        this.oferta = oferta;
    }

    @Override
    public String toString() {
        return "Correo: " + ofertador.getCorreo() +"/n Precio Ofertado: " + oferta;
    }
    
    
}
