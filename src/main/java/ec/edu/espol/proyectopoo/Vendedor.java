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
    public Vendedor(int id, String nombre, String apellido, String organizacion, String correo, String clave){    
        super(id, nombre, apellido, organizacion, correo, clave);
        this.vehiculos = new ArrayList<>();
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
        Vendedor nxtDuenio = null;
        for (Negociante v: negociantes){
            if (Vendedor.existeClave(hashClave, correo, v)){
                nxtDuenio = (Vendedor) v;
            }
        }
        
        if (nxtDuenio instanceof Vendedor){
             System.out.print("Placa: ");
            String placa = sc.nextLine();

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Modelo: ");
            String modelo = sc.nextLine();

            System.out.print("Tipo de motor: ");
            String tipoMotor = sc.nextLine();

            System.out.print("Año: ");
            int anio = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea después de leer el entero

            System.out.print("Recorrido: ");
            double recorrido = sc.nextDouble();
            sc.nextLine(); // Consumir el salto de línea después de leer el punto flotante

            System.out.print("Color: ");
            String color = sc.nextLine();

            System.out.print("Tipo de combustible: ");
            String tipoCombustible = sc.nextLine();
        
            System.out.print("Precio: ");
            double precio = sc.nextDouble();
        
            System.out.print("Tipo de Vehículo: ");
            String tipoVeh = sc.nextLine();
        
            if (tipoVeh.equals("Camioneta") || tipoVeh.equals("Auto")){
                System.out.print("Vidrios: ");
                String vidrio = sc.nextLine();

                System.out.print("Transmisión: ");
                String transm = sc.nextLine();

                if (tipoVeh.equals("Auto")){
                    Auto vehiculo = new Auto(placa, marca, modelo, tipoMotor, color, tipoCombustible, anio, recorrido,  precio, tipoVeh, vidrio, transm);
                    Vehiculo.saveFileVeh(vehiculo);
                }else if (tipoVeh.equals("Camioneta")){
                    System.out.print("Tracción: ");
                    String traccion = sc.nextLine();
                    Camioneta vehiculo = new Camioneta(placa, marca, modelo, tipoMotor, color, tipoCombustible, anio, recorrido,  precio, tipoVeh, vidrio, transm, traccion);
                    Vehiculo.saveFileVeh(vehiculo);
                }
            }else{
               Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, tipoMotor, color, tipoCombustible, anio, recorrido,  precio, tipoVeh);
               Vehiculo.saveFileVeh(vehiculo);
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
