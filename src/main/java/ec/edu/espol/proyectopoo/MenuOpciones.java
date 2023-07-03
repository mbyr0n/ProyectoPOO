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
public class MenuOpciones {
    //atributos 
    private Negociante negociante;
    protected ArrayList<Negociante> negociantes;
    
    //metodos
    public MenuOpciones(Negociante negociante, ArrayList<Negociante> negociantes) {
        this.negociante = negociante;
        this.negociantes = negociantes;
    }
    
    //getter y setter
    public Negociante getNegociante() {
        return negociante;
    }

    public void setNegociante(Negociante negociante) {
        this.negociante = negociante;
    }

    public ArrayList<Negociante> getNegociantes() {
        return negociantes;
    }

    public void setNegociantes(ArrayList<Negociante> negociantes) {
        this.negociantes = negociantes;
    }
    
    //metodos
    
    
    
}
