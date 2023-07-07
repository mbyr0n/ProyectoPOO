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
public class Camioneta extends Vehiculo {
    //atributos
    private String vidrios, transmision, traccion;
    
    //constructor
    
    public Camioneta(String vidrios, String transmision, String traccion, String placa, String marca, String modelo, String tipoMotor, String color, String tipoComb, int anio, double recorrido, double precio, String tipoVeh, String duenio) {
        super(placa, marca, modelo, tipoMotor, color, tipoComb, anio, recorrido, precio, tipoVeh, duenio);
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.traccion = traccion;
    }
    
    //getter y setter

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
    
    
}
