/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author byron
 */
public class Vendedor extends Negociante {
    //atributos
    ArrayList<Vehiculo> vehiculos;
    
    //constructor
    public Vendedor(ArrayList<Vehiculo> vehiculos, int id, String nombre, String apellido, String organizacion, String correo, String clave){    
        super(id, nombre, apellido, organizacion, correo, clave);
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
    public static void registroVendedor(Scanner sc, String nomFile) { //hay que meter lo del hash
        ArrayList<Negociante> negociantes = Negociante.readFile(nomFile);
        System.out.println("Ingrese sus Nombres:");
        String nom = sc.nextLine();
        System.out.println("Ingrese sus Apellidos:");
        String ape = sc.nextLine();
        System.out.println("Ingrese su Organizacion:");
        String org = sc.nextLine();
        int id = Util.nextID(nomFile);
        
        String correo = "";
        boolean correoRep = false;
        do{
        System.out.println("Ingrese su correo:");
        correo = sc.nextLine();
        for (Negociante n: negociantes){
            if (n.getCorreo().equals(correo))
                correoRep = true;
        }
        if (correoRep)
            System.out.println("Correo existente.");
        }while(!correoRep);
        
        System.out.println("Ingrese su Clave:");
        String c = sc.nextLine();
        
        Negociante nV = new Negociante(id, nom, ape, org, correo, c);
        Negociante.saveFile(nV, nomFile);
    }
    
    
    public void registroVehiculo(String correo, String clave){
        
    }
    public void aceptarOferta(String correo, String clave){
    }
    public void revisarOfertas(String placa){
    }
    public void regresar(){
    }
}
