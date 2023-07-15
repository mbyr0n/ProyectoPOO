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
public class MenuOpciones {
    //atributos 
    private Negociante negociante;
    protected ArrayList<Negociante> negociantes;
    
    //metodos
    public MenuOpciones(Negociante negociante, ArrayList<Negociante> negociantes) {
        this.negociante = negociante;
        this.negociantes = negociantes;
    }
    
    //getter y setter
    public Negociante getNegociante() {
        return negociante;
    }

    public void setNegociante(Negociante negociante) {
        this.negociante = negociante;
    }

    public ArrayList<Negociante> getNegociantes() {
        return negociantes;
    }

    public void setNegociantes(ArrayList<Negociante> negociantes) {
        this.negociantes = negociantes;
    }
    
    //metodos
    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Vendedor");
            System.out.println("2. Comprador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    mostrarMenuVendedor();
                    break;
                case 2:
                    mostrarMenuComprador();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 3);
    }

    //método para mostrar el menú del vendedor
    public static void mostrarMenuVendedor(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú del Vendedor:");
            System.out.println("1. Registrar un nuevo vendedor");
            System.out.println("2. Registrar un nuevo vehículo");
            System.out.println("3. Aceptar oferta");
            System.out.println("4. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    // Lógica para registrar un nuevo vendedor
                    break;
                case 2:
                    // Lógica para registrar un nuevo vehículo
                    break;
                case 3:
                    // Lógica para aceptar una oferta
                    break;
                case 4:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 4);
    }

    //método para mostrar el menú del comprador
    public void mostrarMenuComprador() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú del Comprador:");
            System.out.println("1. Registrar un nuevo comprador");
            System.out.println("2. Ofertar por un vehículo");
            System.out.println("3. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    // Lógica para registrar un nuevo comprador
                    break;
                case 2:
                    // Lógica para ofertar por un vehículo
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 3);
    }

}
