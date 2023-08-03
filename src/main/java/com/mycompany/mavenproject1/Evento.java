/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Kevin
 */
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String ciudad;
    private String direccion;
    private String categoria;
    private String fecha;
    private int capacidad;
    private int capacidadDisponible;
    private List<String> asientos;

    public Evento(String ciudad, String direccion, String categoria, String fecha, int capacidad) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.capacidadDisponible = capacidad;
        this.asientos = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getCapacidadDisponible() {
        return capacidadDisponible;
    }

    public List<String> getAsientos() {
        return asientos;
    }

    public void agregarAsiento(String asiento) {
        asientos.add(asiento);
        capacidadDisponible--;
    }

    public void editarEvento(String ciudad, String direccion, String categoria, String fecha, int capacidad) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.capacidadDisponible = capacidad - asientos.size();
    }

    public void inactivarEvento() {
        this.capacidadDisponible = 0;
    }
}

