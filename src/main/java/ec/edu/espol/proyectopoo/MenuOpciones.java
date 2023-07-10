/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

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
    public static void Vendedor(Scanner sc) throws NoSuchAlgorithmException{ //opciones de vendedor para solo llamar en el main
        int acc = 0;
        System.out.println("1. Registrar nuevo Vendedor");
        System.out.println("2. Registrar nuevo Vehículo");
        System.out.println("3. Aceptar Oefrta");
        System.out.println("4. Regresar");
        acc = sc.nextInt();
        sc.nextLine();
        
        switch (acc) {
            case 1:
                Vendedor.registroVendedor(sc, "negociantes.txt");
                break;
            case 2:
                Vendedor.registroVehiculo(sc);
                break;
            case 3:
                Vendedor.revisarOfertas(sc);
                break;
            case 4:
                //regresar
                break;
            default:
                break;
        }
    }//falta terminar los metodos pero en la clase vendedor
    
    
}
