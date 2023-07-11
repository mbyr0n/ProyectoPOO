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
public class Camioneta extends Auto{
    //atributos
    private String traccion;
    
    //constructor
    
    public Camioneta(int id, String placa, String marca, String modelo, String tipoMotor, String color, String tipoComb, int anio, double recorrido, double precio, String tipoVeh, String vidrios, String transmision, String traccion) {
        super(id, placa, marca, modelo, tipoMotor, color, tipoComb, anio, recorrido, precio, tipoVeh, vidrios, transmision);
        this.traccion = traccion;
    }

    @Override
    public String toString() {
        return super.toString() + "," + traccion;
    }
    
    //getter y setter

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
    
    
}
