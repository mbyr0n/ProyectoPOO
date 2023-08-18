/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.util.ArrayList;

/**
 *
 * @author Kevin Magallanes
 */
public class VehiculoSearchUtil {
    public static ArrayList<Vehiculo> buscarVehiculo(ArrayList<Vehiculo> listaVehiculos, String tipoVehiculo, double recorridoMinimo, double recorridoMaximo, int anioMinimo, int anioMaximo, double precioMinimo, double precioMaximo) {
        ArrayList<Vehiculo> vehiculosEncontrados = new ArrayList<>();

        for (Vehiculo vehiculo : listaVehiculos) {
            if (tipoVehiculo.equalsIgnoreCase(vehiculo.getTipoVeh()) || tipoVehiculo.equalsIgnoreCase("todo")) {
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
}
