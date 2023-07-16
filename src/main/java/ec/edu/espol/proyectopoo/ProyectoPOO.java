/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyectopoo;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author byron
 */
public class ProyectoPOO {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        System.out.println("VENTA DE VEHICULOS \n");
        
        Scanner sc = new Scanner(System.in);
        MenuOpciones.mostrarMenuPrincipal(sc);
    }
}
