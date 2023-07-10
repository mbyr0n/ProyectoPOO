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
        }while(Negociante.existeCorreo(correo, negociantes));
        
        System.out.println("Ingrese su Clave:");
        String c = sc.nextLine();
        
        String hashClave = Util.toHexString(Util.generarHash(c));
        
        Negociante nV = new Negociante(id, nom, ape, org, correo, hashClave);
        Negociante.saveFileNeg(nV, nomFile);
    }
    
    
    public static void registroVehiculo(Scanner sc) throws NoSuchAlgorithmException{ //terminado
        System.out.println("Ingrese su correo:");
        String correo = sc.nextLine();
        System.out.println("Ingrese su Clave:");
        String c = sc.nextLine();
        String hashClave = Util.toHexString(Util.generarHash(c));
        
        Negociante usuario = Negociante.existeClaveCorreo(hashClave, correo);
        
        if (null != usuario){
            Vendedor nxtDuenio = (Vendedor) usuario;
            System.out.print("Placa: ");
            String placa = sc.nextLine();
            
            ArrayList<Vehiculo> vehs = Vehiculo.readFileVeh();
            boolean filt = true;
            for (Vehiculo v: vehs){
                if (v.placa.equals(placa)){
                    System.out.println("Placa ya existente.");
                    filt = false;
                }
            }
            
            if (filt == true){
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
    }
    
    public void aceptarOferta(String correo, String clave){
    }
    
    
    public static void revisarOfertas(Scanner sc) throws NoSuchAlgorithmException{
        System.out.println("Ingrese su correo:");
        String correo = sc.nextLine();
        System.out.println("Ingrese su Clave:");
        String c = sc.nextLine();
        String hashClave = Util.toHexString(Util.generarHash(c));
        
        Vendedor nxtDuenio = (Vendedor) Negociante.existeClaveCorreo(hashClave, correo);
        
        System.out.print("Ingrese la Placa: ");
        String placa = sc.nextLine();
        
        ArrayList<Vehiculo> vehs = Vehiculo.readFileVeh();
        for (Vehiculo v: vehs){
            if (v.getPlaca().equals(placa))
                System.out.println(v.getMarca()+" " + v.getModelo() + " Precio: " + v.getPrecio());
        }
        
        
        
    }
    
    
    public void regresar(){
    }
    
}
