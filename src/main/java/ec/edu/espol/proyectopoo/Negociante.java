/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author byron
 */
public class Negociante {
    //atributos
    protected int id;
    protected String nombre, apellido, organizacion, correo, clave;
    
    //constructor
    public Negociante() {
    }
    
    
    public Negociante(int id, String nombre, String apellido, String organizacion, String correo, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.organizacion = organizacion;
        this.correo = correo;
        this.clave = clave;
    }

    public Negociante(String nombre, String apellido, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }
    
    //getter y setter
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //metodos
    public static void registro(Scanner sc, String nomFile) throws NoSuchAlgorithmException { //completada
        ArrayList<Negociante> negociantes = Negociante.readFileNeg(nomFile);
        System.out.println("Ingrese sus Nombres:");
        String nom = sc.nextLine();
        System.out.println("Ingrese sus Apellidos:");
        String ape = sc.nextLine();
        System.out.println("Ingrese su Organizacion:");
        String org = sc.nextLine();
        int id = Util.nextID(nomFile);
        
        String correo = ""; //obligar que ingrese un correo unico
        do{
        System.out.println("Ingrese su correo:");
        correo = sc.nextLine();
        }while(Negociante.existeCorreo(correo, negociantes));
        
        System.out.println("Ingrese su Clave:");
        String c = sc.nextLine();
        
        String hashClave = Util.toHexString(Util.generarHash(c)); //transformar la clave a hash y eso se guarda
        
        Negociante nV = new Negociante(id, nom, ape, org, correo, hashClave);
        Negociante.saveFileNeg(nV, nomFile); //guardo en el archivo
    }
    
    //metodos para leer y editar archivos donde estan los negociantes
    public static ArrayList<Negociante> readFileNeg(String nomFile){
        ArrayList<Negociante> negociantes = new ArrayList<>();
        
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){ //transcribi y adapte lo del video del profe pero tengo dudas porque negociante puede ser vendedor o comprador
                String linea = sc.nextLine();
                String[] datos = linea.split(",");
                Negociante nextNeg = new Negociante(parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4], datos[5]);
                negociantes.add(nextNeg);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return negociantes;
    }
    
    public static void saveFileNeg(Negociante n, String nomFile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile), true))){
            pw.println(n.id + "," + n.nombre + "," + n.apellido + "," + n.organizacion + "," + n.correo + "," + n.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     //metodos de ayuda
    public static boolean existeCorreo(String correo, ArrayList<Negociante> negociantes) {
        for (Negociante vendedor : negociantes){
            if (vendedor.getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }
    
    public static Negociante existeClaveCorreo(String clave, String correo){
        ArrayList<Negociante> negociantes = Negociante.readFileNeg("negociantes.txt");
        Negociante usuario = new Negociante();
        for (Negociante u: negociantes){
            if (usuario.getClave().equals(clave) && usuario.getCorreo().equals(correo)){
                usuario = u;
            }
        }
        return usuario;
        
    }
}
