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
    public static void registroVendedor(Scanner sc, String nomFile) throws NoSuchAlgorithmException { //completada
        ArrayList<Negociante> negociantes = Negociante.readFileNeg(nomFile);
        System.out.println("Ingrese sus Nombres:");
        String nom = sc.nextLine();
        System.out.println("Ingrese sus Apellidos:");
        String ape = sc.nextLine();
        System.out.println("Ingrese su Organizacion:");
        String org = sc.nextLine();
        int id = Util.nextID(nomFile);
        
        String correo = "";
        do{
        System.out.println("Ingrese su correo:");
        correo = sc.nextLine();
        }while(Vendedor.existeCorreo(correo, negociantes));
        
        System.out.println("Ingrese su Clave:");
        String c = sc.nextLine();
        
        String hashClave = Util.toHexString(Util.generarHash(c));
        
        Negociante nV = new Negociante(id, nom, ape, org, correo, hashClave);
        Negociante.saveFileNeg(nV, nomFile);
    }
    
    
    public static void registroVehiculo(Scanner sc) throws NoSuchAlgorithmException{
        System.out.println("Ingrese su correo:");
        String correo = sc.nextLine();
        System.out.println("Ingrese su Clave:");
        String c = sc.nextLine();
        String hashClave = Util.toHexString(Util.generarHash(c));
        
        ArrayList<Negociante> negociantes = Negociante.readFileNeg("negociantes.txt");
        for (Negociante v: negociantes){
            if (Vendedor.existeClave(hashClave, correo, v)){
            
            }
        }
        
    }
    public void aceptarOferta(String correo, String clave){
    }
    public void revisarOfertas(String placa){
    }
    public void regresar(){
    }
    
    public static boolean existeCorreo(String correo, ArrayList<Negociante> negociantes) {
        for (Negociante vendedor : negociantes) {
            if (vendedor.getCorreo().equalsIgnoreCase(correo)) {
                
                return true;
            }
        }
        return false;
    }
    
    public static boolean existeClave(String clave, String correo, Negociante vendedor) {
        if (vendedor.getClave().equalsIgnoreCase(clave) && vendedor.getCorreo().equalsIgnoreCase(correo)) {
                return true;
        }
        return false;
    }
}
