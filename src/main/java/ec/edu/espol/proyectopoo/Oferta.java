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
    private int idComp;
    private int idVeh;
    private double oferta;

public Oferta(){
    }

    public Oferta(int idComp, int idVeh, double oferta) {
        this.idComp = idComp;
        this.idComp = idVeh;
        this.oferta = oferta;
    }

    @Override
    public String toString() {
        return "/n Precio Ofertado: " + oferta;
    }

    public int getIdComp() {
        return idComp;
    }

    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }

    public int getIdVeh() {
        return idVeh;
    }

    public void setIdVeh(int idVeh) {
        this.idVeh = idVeh;
    }

    public double getOferta() {
        return oferta;
    }

    public void setOferta(double oferta) {
        this.oferta = oferta;
    }
    
    
    
}
