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
public class Auto extends Vehiculo{
    //atributos
    private String vidrio, transmicion;
    
    //constructor
    public Auto(int id, String placa, String marca, String modelo, String tipoMotor, String color, String tipoComb, int anio, double recorrido, double precio, String tipoVeh, String vidrio, String transmicion) {
        super(id, placa, marca, modelo, tipoMotor, color, tipoComb, anio, recorrido, precio, tipoVeh);
        this.vidrio = vidrio;
        this.transmicion = transmicion;
    }

    @Override
    public String toString() {
        return super.toString() + "," + vidrio + "," + transmicion;
    }
    
    
    //getter y setter

    public String getVidrio() {
        return vidrio;
    }

    public void setVidrio(String vidrio) {
        this.vidrio = vidrio;
    }

    public String getTransmicion() {
        return transmicion;
    }

    public void setTransmicion(String transmicion) {
        this.transmicion = transmicion;
    }
    
}
