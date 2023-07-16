/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
    
    public static ArrayList<Oferta> readFileOf(){
        ArrayList<Oferta> ofertas = new ArrayList<>();
        
        try(Scanner sc = new Scanner(new File("ofertas.txt"))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] datos = linea.split(",");
                Oferta nextOf = new Oferta(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), Double.parseDouble(datos[2]));
                ofertas.add(nextOf);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ofertas;
    }
    
    public static void saveFileOf(Oferta o){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("ofertas.txt"), true))){
            pw.println(o.idComp + "," + o.idVeh + "," + o.oferta);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
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
