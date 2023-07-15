/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author byron
 */
public class Comprador extends Negociante {
    //atributos
    private ArrayList<Oferta> ofertas;
    
    //constructor
    public Comprador(int id, String nombre, String apellido, String organizacion, String correo, String clave) {
        super(id, nombre, apellido, organizacion, correo, clave);
        this.ofertas = new ArrayList<>();
    }
    
    //metodos
    public void registroComprador() throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Registro de Nuevo Comprador ---");
        String nomFile = "nombreArchivo.txt";

        Negociante.registro(scanner, nomFile);
    }
    public void ofertarPorVehiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Búsqueda de Vehículos ---");

        System.out.print("Tipo de vehículo (Ingrese 'auto', 'camioneta' o 'moto'): ");
        String tipoVehiculo = scanner.nextLine();

        System.out.print("Recorrido mínimo (Ingrese 0 si no desea especificar): ");
        double recorridoMinimo = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Recorrido máximo (Ingrese un número alto si no desea especificar): ");
        double recorridoMaximo = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Año mínimo (Ingrese 0 si no desea especificar): ");
        int anioMinimo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Año máximo (Ingrese un número alto si no desea especificar): ");
        int anioMaximo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Precio mínimo (Ingrese 0 si no desea especificar): ");
        double precioMinimo = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Precio máximo (Ingrese un número alto si no desea especificar): ");
        double precioMaximo = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        ArrayList<Vehiculo> vehiculosEncontrados = buscarVehiculo(tipoVehiculo, recorridoMinimo, recorridoMaximo,
                anioMinimo, anioMaximo, precioMinimo, precioMaximo);

        if (vehiculosEncontrados.isEmpty()) {
            System.out.println("No se encontraron vehículos que coincidan con los criterios de búsqueda.");
            return;
        }

        int posicionActual = 0;
        boolean continuarRevisando = true;

        while (continuarRevisando) {
            Vehiculo vehiculo = vehiculosEncontrados.get(posicionActual);
            System.out.println("--- Vehículo ---");
            System.out.println("Tipo: " + vehiculo.getTipoVeh());
            System.out.println("Placa: " + vehiculo.getPlaca());
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Año: " + vehiculo.getAnio());
            System.out.println("Recorrido: " + vehiculo.getRecorrido());
            System.out.println("Precio: " + vehiculo.getPrecio());

            System.out.println("1. Siguiente Vehículo");
            System.out.println("2. Anterior Vehículo");
            System.out.println("3. Realizar Oferta");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    if (posicionActual < vehiculosEncontrados.size() - 1) {
                        posicionActual++;
                        System.out.println("Revisando siguiente vehículo...");
                    } else {
                        System.out.println("No hay más vehículos disponibles.");
                    }
                    break;
                case 2:
                    if (posicionActual > 0) {
                        posicionActual--;
                        System.out.println("Revisando vehículo anterior...");
                    } else {
                        System.out.println("Ya estás en el primer vehículo.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el precio ofertado: ");
                    double precioOfertado = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer del scanner

                    registrarOferta(vehiculo, precioOfertado);
                    continuarRevisando = false;
                    break;
                case 4:
                    continuarRevisando = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        }
    }

    public ArrayList<Vehiculo> buscarVehiculo(String tipoVehiculo, double recorridoMinimo, double recorridoMaximo,
                                          int anioMinimo, int anioMaximo, double precioMinimo, double precioMaximo) {
    ArrayList<Vehiculo> vehiculosEncontrados = new ArrayList<>();

    ArrayList<Vehiculo> listaVehiculos = Vehiculo.readFileVeh();

    for (Vehiculo vehiculo : listaVehiculos) {
        if (tipoVehiculo.equalsIgnoreCase(vehiculo.getTipoVeh()) ||
                tipoVehiculo.equalsIgnoreCase("todo")) {
            double recorrido = vehiculo.getRecorrido();
            int anio = vehiculo.getAnio();
            double precio = vehiculo.getPrecio();

            if ((recorridoMinimo == 0 || recorrido >= recorridoMinimo) &&
                    (recorridoMaximo == 0 || recorrido <= recorridoMaximo) &&
                    (anioMinimo == 0 || anio >= anioMinimo) &&
                    (anioMaximo == 0 || anio <= anioMaximo) &&
                    (precioMinimo == 0 || precio >= precioMinimo) &&
                    (precioMaximo == 0 || precio <= precioMaximo)) {
                vehiculosEncontrados.add(vehiculo);
            }
        }
    }

    return vehiculosEncontrados;
}


    private void registrarOferta(Vehiculo vehiculo, double precioOfertado) {
        Oferta oferta = new Oferta(this.getId(), vehiculo.getId(), precioOfertado);
        this.ofertas.add(oferta);
        vehiculo.agregarOferta(oferta);
        System.out.println("Oferta realizada con éxito. El vehículo ha sido registrado con su oferta.");
    }
}
