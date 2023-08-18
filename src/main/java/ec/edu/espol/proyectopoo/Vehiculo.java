/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    protected int duenio;
    
    //constructor

    public Vehiculo() {
    }

    
    public Vehiculo(int id, int duenio, String placa, String marca, String modelo, String tipoMotor, String color, String tipoComb, int anio, double recorrido, double precio, String tipoVeh) {
        this.duenio = duenio;
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
    /*public static ArrayList<Vehiculo> readFileVeh(){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        try(Scanner sc = new Scanner(new File("vehiculos.txt"))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] datos = linea.split(",");
                Vehiculo nextVeh = new Vehiculo(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], Integer.parseInt(datos[8]), Double.parseDouble(datos[9]), Double.parseDouble(datos[10]), datos[11]);
                vehiculos.add(nextVeh);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }*/
    public static ArrayList<Vehiculo> readFileVeh() throws IOException {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try (Scanner sc = new Scanner(new File("vehiculos.txt"))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] datos = linea.split(",");
            
                if (datos.length != 12) {
                    throw new IOException("Formato de línea inválido en el archivo vehiculos.txt");
                }
            
                try {
                    Vehiculo nextVeh = new Vehiculo(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], Integer.parseInt(datos[8]), Double.parseDouble(datos[9]), Double.parseDouble(datos[10]), datos[11]);
                    vehiculos.add(nextVeh);
                } catch (NumberFormatException e) {
                    throw new IOException("Error al convertir datos en la línea: " + linea, e);
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo vehiculos.txt", e);
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
    
    public static void rewriteFileVeh(ArrayList<Vehiculo> vehs, Vehiculo v){
        vehs.remove(v);
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("vehiculos.txt"), false))){
            for (Vehiculo veh: vehs){
                pw.println(veh.toString());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /*public Oferta verOfertas(Scanner sc){ //meti aca el metodo ver ofertas para reducir codigo
        int pos = 0;
        int opc = 0;
        ArrayList<Oferta> ofertas = this.ofertas;
        ArrayList<Negociante> negos = Vendedor.readFileNeg("negociantes.txt");
        Oferta nxtOf = new Oferta();
        String mail = "";
        boolean cond = true;
        
        do{
            System.out.println("\nOferta " + (pos+1) + "\n"); 
            for (Negociante n: negos){
                if (n.getId()==ofertas.get(pos).getIdComp())
                    mail = n.getCorreo();
            }
            System.out.println("Correo: " + mail);
            System.out.println("Precio Ofertado: " + ofertas.get(pos).getOferta() + "\n");
            System.out.println("1. Siguiente Oferta");
            if (pos>0){
                System.out.println("2. Anterior Oferta");
                System.out.println("3. Aceptar Oferta");
            }else if(pos==0){
                System.out.println("2. Aceptar Oferta");
            }
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();
            if (opc == 1 && ofertas.size() > pos+1){
                pos += 1;
                opc = 0;
            }else if(opc==1 && ofertas.size()==pos+1){
                System.out.println("No hay más ofertas.");
            }else if(opc==2 && pos>0){
                pos -= 1;
                opc = 0;
            }else if((opc==3 && pos>0) || (opc==2 && pos==0)){
                nxtOf = ofertas.get(pos);
                System.out.println("Ha aceptado la Oferta " + (pos+1) + "por el vehículo " + this.getMarca() + " " + this.getModelo());
                cond = false;
            }else{
                System.out.println("Opción inválida, vuelva a intentar.");
            }
        }while(cond);
        
        return nxtOf;
    }//para avanzar y retroceder por las ofertas disponibles*/
    
    public Oferta verOfertas(Scanner sc) {
        int pos = 0;
        int opc = 0;
        ArrayList<Oferta> ofertas = this.ofertas;
        ArrayList<Negociante> negos = Vendedor.readFileNeg("negociantes.txt");
        Oferta nxtOf = new Oferta();
        boolean cond = true;
        
        do {
            imprimirOfertaInfo(pos, negos, ofertas);
            opc = sc.nextInt();
            sc.nextLine();
            cond = procesarOpcion(opc, pos, ofertas, nxtOf);
        } while (cond);
        
        return nxtOf;
    }

    private void imprimirOfertaInfo(int pos, ArrayList<Negociante> negos, ArrayList<Oferta> ofertas) {
        System.out.println("\nOferta " + (pos + 1) + "\n");
        String mail = obtenerCorreoNegociante(negos, ofertas, pos);
        System.out.println("Correo: " + mail);
        System.out.println("Precio Ofertado: " + ofertas.get(pos).getOferta() + "\n");
        System.out.println("1. Siguiente Oferta");
        if (pos > 0) {
            System.out.println("2. Anterior Oferta");
            System.out.println("3. Aceptar Oferta");
        } else if (pos == 0) {
            System.out.println("2. Aceptar Oferta");
        }
        System.out.print("Seleccione una opción: ");
    }

    private String obtenerCorreoNegociante(ArrayList<Negociante> negos, ArrayList<Oferta> ofertas, int pos) {
        String mail = "";
        for (Negociante n : negos) {
            if (n.getId() == ofertas.get(pos).getIdComp()) {
                mail = n.getCorreo();
                break;
            }
        }
        return mail;
    }

    private boolean procesarOpcion(int opc, int pos, ArrayList<Oferta> ofertas, Oferta nxtOf) {
        if (opc == 1 && ofertas.size() > pos + 1) {
            pos += 1;
        } else if (opc == 1 && ofertas.size() == pos + 1) {
            System.out.println("No hay más ofertas.");
        } else if (opc == 2 && pos > 0) {
            pos -= 1;
        } else if ((opc == 3 && pos > 0) || (opc == 2 && pos == 0)) {
            nxtOf = ofertas.get(pos);
            System.out.println("Ha aceptado la Oferta " + (pos + 1) + " por el vehículo " + this.getMarca() + " " + this.getModelo());
            return false;
        } else {
            System.out.println("Opción inválida, vuelva a intentar.");
        }
        return true;
    }
    
     public static Vehiculo verVehiculos(Scanner sc, ArrayList<Vehiculo> vehs){ //meti aca el metodo ver ofertas para reducir codigo
        int pos = 0;
        int opc = 0;
        Vehiculo nxtVeh = new Vehiculo();
        String mail = "";
        boolean cond = true;
        
        do{
            System.out.println("\nOferta " + (pos+1) + "\n");
            System.out.println("    Vehiculo: " + vehs.get(pos).getMarca() + " " + vehs.get(pos).getModelo() + " de Placa: " + vehs.get(pos).getPlaca() + "\n");
            System.out.println("1. Siguiente Vehiculo");
            if (pos>0){
                System.out.println("2. Anterior Vehiculo");
                System.out.println("3. Eliminar Vehiculo");
            }else if(pos==0){
                System.out.println("2. Eliminar Vehiculo");
            }
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();
            if (opc == 1 && vehs.size() > pos+1){
                pos += 1;
                opc = 0;
            }else if(opc==1 && vehs.size()==pos+1){
                System.out.println("No hay más ofertas.");
            }else if(opc==2 && pos>0){
                pos -= 1;
                opc = 0;
            }else if((opc==3 && pos>0) || (opc==2 && pos==0)){
                nxtVeh = vehs.get(pos);
                System.out.println("Ha eliminado el Vehiculo " + (pos+1) + " " + nxtVeh.getMarca() + " " + nxtVeh.getModelo());
                cond = false;
            }else{
                System.out.println("Opción inválida, vuelva a intentar.");
            }
        }while(cond);
        
        return nxtVeh;
    }

    @Override
    public String toString() {
        return this.id + "," + this.duenio + "," + this.placa + "," + this.marca + "," + this.modelo + "," + this.tipoMotor + "," + this.color + "," + this.tipoComb + "," + this.anio + "," + this.recorrido + ","+this.precio+","+this.tipoVeh;
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

    public int getDuenio() {
        return duenio;
    }

    public void setDuenio(int duenio) {
        this.duenio = duenio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void agregarOferta(Oferta oferta) {
        ofertas.add(oferta);
    }
    
    
}
