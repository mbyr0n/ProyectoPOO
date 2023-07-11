/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author byron
 */
public class Vehiculo {
    //atributos
    protected int id;
    protected String placa, marca, modelo, tipoMotor,color,tipoComb;
    protected int anio;
    protected double recorrido, precio;
    protected String tipoVeh;
    protected ArrayList<Oferta> ofertas;
    protected Vendedor duenio;
    
    //constructor

    public Vehiculo(int id, String placa, String marca, String modelo, String tipoMotor, String color, String tipoComb, int anio, double recorrido, double precio, String tipoVeh) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.color = color;
        this.tipoComb = tipoComb;
        this.anio = anio;
        this.recorrido = recorrido;
        this.precio = precio;
        this.tipoVeh = tipoVeh;
        this.ofertas = new ArrayList<>();
    }
    
    //metodos para leer y editar archivos donde estan los negociantes
    public static ArrayList<Vehiculo> readFileVeh(){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        try(Scanner sc = new Scanner(new File("vehiculos.txt"))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] datos = linea.split(",");
                Vehiculo nextVeh = new Vehiculo(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], Integer.parseInt(datos[7]), Double.parseDouble(datos[8]), Double.parseDouble(datos[9]), datos[10]);
                vehiculos.add(nextVeh);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }
    
    public static void saveFileVeh(Vehiculo v){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("vehiculos.txt"), true))){
            pw.println(v.toString());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Oferta verOfertas(Scanner sc){ //meti aca el metodo ver ofertas para reducir codigo
        int pos = 0;
        int opc = 0;
        ArrayList<Oferta> ofertas = this.ofertas;
        Oferta nxtOf = new Oferta();
        
        do{
            System.out.println("Oferta" + (pos+1)); 
            System.out.println("Correo: " + ofertas.get(pos).getOfertador().getCorreo());
            System.out.println("Precio Ofertado: " + ofertas.get(pos).getOferta());
            System.out.println("1. Siguiente Oferta");
            if (pos>0){
                System.out.println("2. Anterior Oferta");
                System.out.println("3. Aceptar Oferta");
            }else if(pos==0){
                System.out.println("2. Aceptar Oferta");
            }
            opc = sc.nextInt();
            sc.nextLine();
            if (opc == 1){
                pos += 1;
                opc = 0;
            }else if(opc==2 && pos>0){
                pos -= 1;
                opc = 0;
            }else if(opc==3 || (opc==2 && pos==0)){
                nxtOf = ofertas.get(pos);
            }
        }while(opc != 3 || (opc==2 && pos==0));
        
        return nxtOf;
    }//para avanzar y retroceder por las ofertas disponibles

    @Override
    public String toString() {
        return this.id + "," + this.placa + "," + this.marca + "," + this.modelo + "," + this.tipoMotor + "," + this.color + "," + this.tipoComb + "," + this.anio + "," + this.recorrido + ","+this.precio+","+this.tipoVeh;
    }
    
    
    
    //getter y setter

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoComb() {
        return tipoComb;
    }

    public void setTipoComb(String tipoComb) {
        this.tipoComb = tipoComb;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public String getTipoVeh() {
        return tipoVeh;
    }

    public void setTipoVeh(String tipoVeh) {
        this.tipoVeh = tipoVeh;
    }

    public Vendedor getDuenio() {
        return duenio;
    }

    public void setDuenio(Vendedor duenio) {
        this.duenio = duenio;
    }
    
    
    
}
