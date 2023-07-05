/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo;

import java.util.ArrayList;

/**
 *
 * @author byron
 */
public class Vehiculo {
    //atributos
    protected String placa, marca, modelo, tipoMotor,color,tipoComb;
    protected int anio;
    protected double recorrido, precio;
    protected char tipoVeh;
    protected ArrayList<Oferta> ofertas;
    protected Vendedor duenio;
    
    //constructor

    public Vehiculo(String placa, String marca, String modelo, String tipoMotor, String color, String tipoComb, int anio, double recorrido, double precio, char tipoVeh, ArrayList<Oferta> ofertas, Vendedor duenio) {
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
        this.ofertas = ofertas;
        this.duenio = duenio;
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

    public char getTipoVeh() {
        return tipoVeh;
    }

    public void setTipoVeh(char tipoVeh) {
        this.tipoVeh = tipoVeh;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public Vendedor getDuenio() {
        return duenio;
    }

    public void setDuenio(Vendedor duenio) {
        this.duenio = duenio;
    }
    
    
    
}
