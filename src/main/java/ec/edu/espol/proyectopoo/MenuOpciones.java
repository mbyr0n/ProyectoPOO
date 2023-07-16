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
    
    //metodos
    public static void mostrarMenuPrincipal(Scanner scanner) throws NoSuchAlgorithmException {
        int opcion;

        do {
            System.out.println("-------- Menú de Opciones ------- \n");
            System.out.println("1. Vendedor");
            System.out.println("2. Comprador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    MenuOpciones.mostrarMenuVendedor(scanner);
                    break;
                case 2:
                    MenuOpciones.mostrarMenuComprador(scanner);
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
    public static void mostrarMenuVendedor(Scanner scanner) throws NoSuchAlgorithmException{
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
                    Vendedor.registroVendedor(scanner);// Lógica para registrar un nuevo vendedor
                    break;
                case 2:
                    Vendedor.registroVehiculo(scanner);// Lógica para registrar un nuevo vehículo
                    break;
                case 3:
                    Vendedor.revisarOfertas(scanner);// Lógica para aceptar una oferta
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
    public static void mostrarMenuComprador(Scanner scanner) throws NoSuchAlgorithmException {
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
                    Comprador.registroComprador(scanner);// Lógica para registrar un nuevo comprador
                    break;
                case 2:
                    System.out.print("Ingrese su correo:");
                    String correo = scanner.nextLine();
                    System.out.print("Ingrese su Clave:");
                    String c = scanner.nextLine();
                    String hashClave = Util.toHexString(Util.generarHash(c));
        
                    if (Negociante.existeCorreo(correo, Negociante.readFileNeg("negociantes.txt")) && Negociante.existeClave(hashClave, Negociante.readFileNeg("negociantes.txt"))){
                        Negociante us = Negociante.existeClaveCorreo(hashClave, correo);
                        
                        Comprador comp = new Comprador(us.getId(),us.getNombre(),us.getApellido(),us.getOrganizacion(),us.getCorreo(), us.getClave());// Lógica para ofertar por un vehículo
                        comp.ofertarPorVehiculo(scanner);
                    }else{
                        System.out.println("");
                        System.out.println("Usuario no existente.");
                    }
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
