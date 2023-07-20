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
    public Vendedor(){
        super();
    }
    
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
    public static void registroVendedor(Scanner scanner) throws NoSuchAlgorithmException {
        System.out.println("--- Registro de Nuevo Vendedor ---");
        String nomFile = "negociantes.txt";

        Negociante.registro(scanner, nomFile);
    }
     
    
    public static void registroVehiculo(Scanner sc) throws NoSuchAlgorithmException{ //terminado
        System.out.print("Ingrese su correo: ");
        String correo = sc.nextLine();
        System.out.print("Ingrese su Clave: ");
        String c = sc.nextLine();
        String hashClave = Util.toHexString(Util.generarHash(c));
        
        Negociante us = Negociante.existeClaveCorreo(hashClave, correo);
        
        if (null != us){ //verifica que exista un usuario con correo y clave anteriores
            int id = Util.nextID("vehiculos.txt"); // id nuevo
            Vendedor nxtDuenio = new Vendedor(us.getId(),us.getNombre(),us.getApellido(),us.getOrganizacion(),us.getCorreo(), us.getClave());; //por si acaso para ver si hay que incluir un duenio en el constructor del vehiculo
            System.out.print("Placa: ");
            String placa = sc.nextLine();
            
            ArrayList<Vehiculo> vehs = Vehiculo.readFileVeh();
            boolean filt = true;
            for (Vehiculo v: vehs){ //Verificar que la placa no exista en el arhivo
                if (v.placa.equals(placa)){
                    System.out.println("Placa ya existente.");
                    filt = false;
                }
            }
            
            if (filt == true){  //si se cumple el filtro pide los datos para crear al vehiculo
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
                sc.nextLine();
        
                System.out.print("Tipo de Vehículo: ");
                String tipoVeh = sc.nextLine();
        
                if (tipoVeh.equals("Camioneta") || tipoVeh.equals("Auto") || tipoVeh.equals("camioneta") || tipoVeh.equals("auto")){ //Por si es Camioneta o Auto
                    System.out.print("Vidrios: ");
                    String vidrio = sc.nextLine();

                    System.out.print("Transmisión: ");
                    String transm = sc.nextLine();

                    if (tipoVeh.equals("Auto") || tipoVeh.equals("auto")){ 
                        Auto vehiculo = new Auto( id, nxtDuenio.getId(), placa, marca, modelo, tipoMotor, color, tipoCombustible, anio, recorrido,  precio, tipoVeh, vidrio, transm);
                        Vehiculo.saveFileVeh(vehiculo);
                    }else if (tipoVeh.equals("Camioneta") || tipoVeh.equals("Camioneta")){//Por si es Auto ya que los 2 atributos anteriores los hereda de Auto
                        System.out.print("Tracción: ");
                        String traccion = sc.nextLine();
                        Camioneta vehiculo = new Camioneta(id, nxtDuenio.getId(), placa, marca, modelo, tipoMotor, color, tipoCombustible, anio, recorrido,  precio, tipoVeh, vidrio, transm, traccion);
                        Vehiculo.saveFileVeh(vehiculo);
                    }
                }else{//Si no es Auto o Camioneta los guarda nomas
                    Vehiculo vehiculo = new Vehiculo(id, nxtDuenio.getId(), placa, marca, modelo, tipoMotor, color, tipoCombustible, anio, recorrido,  precio, tipoVeh);
                    Vehiculo.saveFileVeh(vehiculo);
                }
            }    
        }
    }
    
    
    public static void revisarOfertas(Scanner sc) throws NoSuchAlgorithmException{// en proceso
        System.out.print("Ingrese su correo: ");
        String correo = sc.nextLine();
        System.out.print("Ingrese su Clave: ");
        String c = sc.nextLine();
        String hashClave = Util.toHexString(Util.generarHash(c));

        if (Negociante.existeClave(hashClave, Negociante.readFileNeg("negociantes.txt")) && Negociante.existeCorreo(correo, Negociante.readFileNeg("negociantes.txt"))){
            Negociante us = Negociante.existeClaveCorreo(hashClave, correo);
            Vendedor nxtDuenio = new Vendedor(us.getId(),us.getNombre(),us.getApellido(),us.getOrganizacion(),us.getCorreo(), us.getClave());
            
            System.out.println("Ingrese la Placa: ");
            String placa = sc.nextLine();
        
            ArrayList<Vehiculo> vehs = Vehiculo.readFileVeh();
            for (Vehiculo v: vehs){
                if (v.getPlaca().equals(placa) && v.getDuenio()==nxtDuenio.getId()){
                    
                    ArrayList<Oferta> ofertas = Oferta.readFileOf();
                    ArrayList<Oferta> ofVeh = new ArrayList<>();
                    
                    for (Oferta o: ofertas){
                        if (v.getId() == o.getIdVeh())
                            ofVeh.add(o);
                    }
                    v.setOfertas(ofVeh);
                    
                    if(v.getOfertas().size()==0){
                        System.out.println("Este vehiculo no tiene ofertas.");
                        return;
                    }
                    System.out.println(v.getMarca()+ " " + v.getModelo() + " Precio: " + v.getPrecio());
                    System.out.println("Se han realizado " + v.getOfertas().size() + " ofertas");
                
                    Oferta of = v.verOfertas(sc);
                    
                    Vehiculo.rewriteFileVeh(vehs, v);
                    
                    ArrayList<Negociante> negocs = Negociante.readFileNeg("negociantes.txt");
                    String destinatario = "";
                    for (Negociante gan: negocs){
                        if (gan.getId() == of.getIdComp())
                            destinatario = gan.getCorreo();
                    }

                    Util.enviarConGMail(destinatario, v.getMarca()+ " " + v.getModelo());
                }else if (v.getPlaca().equals(placa) && v.getDuenio()!=nxtDuenio.getId()){
                    System.out.println("No puede ver ofertas de este carro, ya que no es suyo.");
                }
            }
        }        
    }
    
    public static void eliminarVehiculo(Scanner sc) throws NoSuchAlgorithmException{
        System.out.print("Ingrese su correo: ");
        String correo = sc.nextLine();
        System.out.print("Ingrese su Clave: ");
        String c = sc.nextLine();
        String hashClave = Util.toHexString(Util.generarHash(c));

        if (Negociante.existeClave(hashClave, Negociante.readFileNeg("negociantes.txt")) && Negociante.existeCorreo(correo, Negociante.readFileNeg("negociantes.txt"))){
            Negociante us = Negociante.existeClaveCorreo(hashClave, correo);
            Vendedor nxtDuenio = new Vendedor(us.getId(),us.getNombre(),us.getApellido(),us.getOrganizacion(),us.getCorreo(), us.getClave());

            System.out.println("Sus vehiculos son: ");

            ArrayList<Vehiculo> vehs = Vehiculo.readFileVeh();
            ArrayList<Vehiculo> filt = new ArrayList<>();
        for (Vehiculo v: vehs){
            if (v.getDuenio()==nxtDuenio.getId()){
                filt.add(v);
            }   
        }

            Vehiculo elmVeh = Vehiculo.verVehiculos(sc, filt);
            Vehiculo.rewriteFileVeh(vehs, elmVeh);
        }
    }
    
}
