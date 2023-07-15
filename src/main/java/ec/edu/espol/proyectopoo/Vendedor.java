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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    

    //metodos
    public void registroVendedor() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Registro de Nuevo Vendedor ---");
        String nomFile = "nombreArchivo.txt";

        Negociante.registro(scanner, nomFile);
    }
     
    
    public static void registroVehiculo(Scanner sc) throws NoSuchAlgorithmException{ //terminado
        System.out.print("Ingrese su correo:");
        String correo = sc.nextLine();
        System.out.print("Ingrese su Clave:");
        String c = sc.nextLine();
        String hashClave = Util.toHexString(Util.generarHash(c));
        
        Negociante usuario = Negociante.existeClaveCorreo(hashClave, correo);
        System.out.println(usuario);
        
        if (null != usuario){ //verifica que exista un usuario con correo y clave anteriores
            int id = Util.nextID("vehiculos.txt"); // id nuevo
            //Vendedor nxtDuenio = (Vendedor) usuario; //por si acaso para ver si hay que incluir un duenio en el constructor del vehiculo
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
        
                if (tipoVeh.equals("Camioneta") || tipoVeh.equals("Auto")){ //Por si es Camioneta o Auto
                    System.out.print("Vidrios: ");
                    String vidrio = sc.nextLine();

                    System.out.print("Transmisión: ");
                    String transm = sc.nextLine();

                    if (tipoVeh.equals("Auto")){ 
                        Auto vehiculo = new Auto(id, placa, marca, modelo, tipoMotor, color, tipoCombustible, anio, recorrido,  precio, tipoVeh, vidrio, transm);
                        Vehiculo.saveFileVeh(vehiculo);
                    }else if (tipoVeh.equals("Camioneta")){//Por si es Auto ya que los 2 atributos anteriores los hereda de Auto
                        System.out.print("Tracción: ");
                        String traccion = sc.nextLine();
                        Camioneta vehiculo = new Camioneta(id, placa, marca, modelo, tipoMotor, color, tipoCombustible, anio, recorrido,  precio, tipoVeh, vidrio, transm, traccion);
                        Vehiculo.saveFileVeh(vehiculo);
                    }
                }else{//Si no es Auto o Camioneta los guarda nomas
                    Vehiculo vehiculo = new Vehiculo(id, placa, marca, modelo, tipoMotor, color, tipoCombustible, anio, recorrido,  precio, tipoVeh);
                    Vehiculo.saveFileVeh(vehiculo);
                }
            }    
        }
    }
    
    
    public static void revisarOfertas(Scanner sc) throws NoSuchAlgorithmException{// en proceso
        System.out.println("Ingrese su correo:");
        String correo = sc.nextLine();
        System.out.println("Ingrese su Clave:");
        String c = sc.nextLine();
        String hashClave = Util.toHexString(Util.generarHash(c));
        
        Vendedor nxtDuenio = (Vendedor) Negociante.existeClaveCorreo(hashClave, correo);
        
        System.out.println("Ingrese la Placa: ");
        String placa = sc.nextLine();
        
        ArrayList<Vehiculo> vehs = Vehiculo.readFileVeh();
        for (Vehiculo v: vehs){
            if (v.getPlaca().equals(placa)){
                System.out.println(v.getMarca()+" " + v.getModelo() + " Precio: " + v.getPrecio());
                System.out.println("Se han realizado " + v.getOfertas().size() + "ofertas");
                
                Oferta of = v.verOfertas(sc);
                
            }
        }
        
        
        
    }
    
    
    public void regresar(){
    }
    
}
