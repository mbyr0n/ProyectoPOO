/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Iván
 */
public class Util {
    
    private Util(){}
    
    public static int nextID(String nomFile){
        int id = 0;
        try (Scanner sc = new Scanner(new File(nomFile))){
            String linea = sc.nextLine();
            String[] tokens = linea.split(",");
            id = Integer.parseInt(tokens[0]);
        }
        catch(Exception e){
        }
        
        return id+1;
    }
}
