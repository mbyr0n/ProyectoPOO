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
        System.out.println("VENTA DE VEHICULOS");
        System.out.println(" ");
        Scanner sc = new Scanner(System.in);
        Negociante negociante = new Negociante(); 
        ArrayList<Negociante> negociantes = new ArrayList<>();
        MenuOpciones menu = new MenuOpciones(negociante, negociantes);
        menu.mostrarMenuPrincipal();
    }
}
